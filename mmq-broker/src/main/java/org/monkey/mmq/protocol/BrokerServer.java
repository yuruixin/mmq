/*
 * Copyright 2021-2021 Monkey Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.monkey.mmq.protocol;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.mqtt.MqttDecoder;
import io.netty.handler.codec.mqtt.MqttEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.monkey.mmq.codec.MqttWebSocketCodec;
import org.monkey.mmq.config.BrokerProperties;
import org.monkey.mmq.config.Loggers;
import org.monkey.mmq.core.utils.LoggerUtils;
import org.monkey.mmq.metadata.system.SystemInfoMateData;
import org.monkey.mmq.persistent.ConsistencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLEngine;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.UUID;

/**
 * Netty启动Broker
 * @author Solley
 */
@Component
public class BrokerServer {

	/**
	 * 唯一主键
	 */
	public static final String id = UUID.randomUUID().toString();

	@Autowired
	private BrokerProperties brokerProperties;

	@Autowired
	private ProtocolProcess protocolProcess;

	private EventLoopGroup bossGroup;

	private EventLoopGroup workerGroup;

	private SslContext sslContext;

	private Channel channel;

	private Channel websocketChannel;

	@PostConstruct
	public void start() throws Exception {
		LoggerUtils.printIfInfoEnabled(Loggers.BROKER_PROTOCOL,"Initializing {} MQTT Broker ...", "[" + id + "]");
		bossGroup = brokerProperties.isUseEpoll() ? new EpollEventLoopGroup() : new NioEventLoopGroup();
		workerGroup = brokerProperties.isUseEpoll() ? new EpollEventLoopGroup() : new NioEventLoopGroup();
		if (brokerProperties.getSslEnabled()) {
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("keystore/server.pfx");
			keyStore.load(inputStream, brokerProperties.getSslPassword().toCharArray());
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			kmf.init(keyStore, brokerProperties.getSslPassword().toCharArray());
			sslContext = SslContextBuilder.forServer(kmf).build();
		}
		mqttServer();
		websocketServer();
		LoggerUtils.printIfInfoEnabled(Loggers.BROKER_PROTOCOL,"MQTT Broker {} is up and running. Open SSLPort: {} WebSocketSSLPort: {}", "[" + id + "]", brokerProperties.getPort(), brokerProperties.getWebsocketPort());
	}

	@PreDestroy
	public void stop() {
		LoggerUtils.printIfInfoEnabled(Loggers.BROKER_PROTOCOL,"Shutdown {} MQTT Broker ...", "[" +id + "]");
		bossGroup.shutdownGracefully();
		bossGroup = null;
		workerGroup.shutdownGracefully();
		workerGroup = null;
		channel.closeFuture().syncUninterruptibly();
		channel = null;
		websocketChannel.closeFuture().syncUninterruptibly();
		websocketChannel = null;
		LoggerUtils.printIfInfoEnabled(Loggers.BROKER_PROTOCOL,"MQTT Broker {} shutdown finish.", "[" + id + "]");
	}

	private void mqttServer() throws Exception {
		ServerBootstrap sb = new ServerBootstrap();
		sb.group(bossGroup, workerGroup)
			.channel(brokerProperties.isUseEpoll() ? EpollServerSocketChannel.class : NioServerSocketChannel.class)
			// handler在初始化时就会执行
			.handler(new LoggingHandler(LogLevel.INFO))
			// childHandler会在客户端成功connect后才执行
			.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel socketChannel) throws Exception {
					ChannelPipeline channelPipeline = socketChannel.pipeline();
					// Netty提供的心跳检测
					channelPipeline.addFirst("idle", new IdleStateHandler(0, 0, brokerProperties.getKeepAlive()));
					if (brokerProperties.getSslEnabled()) {
						// Netty提供的SSL处理
						SSLEngine sslEngine = sslContext.newEngine(socketChannel.alloc());
						sslEngine.setUseClientMode(false);        // 服务端模式
						sslEngine.setNeedClientAuth(false);        // 不需要验证客户端
						sslEngine.setEnabledCipherSuites(new String[]{
								"TLS_RSA_WITH_AES_256_CBC_SHA256",
								"TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",
								"TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"
						});
						channelPipeline.addLast("ssl", new SslHandler(sslEngine));
					}
					channelPipeline.addLast("decoder", new MqttDecoder());
					channelPipeline.addLast("encoder", MqttEncoder.INSTANCE);
					channelPipeline.addLast("broker", new BrokerHandler(protocolProcess));
				}
			})
			.option(ChannelOption.SO_BACKLOG, brokerProperties.getSoBacklog())
			.childOption(ChannelOption.SO_KEEPALIVE, brokerProperties.isSoKeepAlive());
		channel = sb.bind(brokerProperties.getPort()).sync().channel();
	}

	private void websocketServer() throws Exception {
		ServerBootstrap sb = new ServerBootstrap();
		sb.group(bossGroup, workerGroup)
			.channel(brokerProperties.isUseEpoll() ? EpollServerSocketChannel.class : NioServerSocketChannel.class)
			// handler在初始化时就会执行
			.handler(new LoggingHandler(LogLevel.INFO))
			.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel socketChannel) throws Exception {
					ChannelPipeline channelPipeline = socketChannel.pipeline();
					// Netty提供的心跳检测
					channelPipeline.addFirst("idle", new IdleStateHandler(0, 0, brokerProperties.getKeepAlive()));
					if (brokerProperties.getSslEnabled()) {
						// Netty提供的SSL处理
						SSLEngine sslEngine = sslContext.newEngine(socketChannel.alloc());
						sslEngine.setUseClientMode(false);        // 服务端模式
						sslEngine.setNeedClientAuth(false);        // 不需要验证客户端
//						sslEngine.setEnabledCipherSuites(new String[]{
//								"TLS_RSA_WITH_AES_256_CBC_SHA256"
//						});
						channelPipeline.addLast("ssl", new SslHandler(sslEngine));
					}
					// 将请求和应答消息编码或解码为HTTP消息
					channelPipeline.addLast("http-codec", new HttpServerCodec());
					// 将HTTP消息的多个部分合成一条完整的HTTP消息
					channelPipeline.addLast("aggregator", new HttpObjectAggregator(1048576));
					// 将HTTP消息进行压缩编码
					channelPipeline.addLast("compressor ", new HttpContentCompressor());
					channelPipeline.addLast("protocol", new WebSocketServerProtocolHandler(brokerProperties.getWebsocketPath(), "mqtt,mqttv3.1,mqttv3.1.1", true, 65536));
					channelPipeline.addLast("mqttWebSocket", new MqttWebSocketCodec());
					channelPipeline.addLast("decoder", new MqttDecoder());
					channelPipeline.addLast("encoder", MqttEncoder.INSTANCE);
					channelPipeline.addLast("broker", new BrokerHandler(protocolProcess));
				}
			})
			.option(ChannelOption.SO_BACKLOG, brokerProperties.getSoBacklog())
			.childOption(ChannelOption.SO_KEEPALIVE, brokerProperties.isSoKeepAlive());
		websocketChannel = sb.bind(brokerProperties.getWebsocketPort()).sync().channel();
	}

}
