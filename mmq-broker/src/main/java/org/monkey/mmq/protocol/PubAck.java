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

import io.netty.channel.Channel;
import io.netty.handler.codec.mqtt.MqttMessageIdVariableHeader;
import io.netty.util.AttributeKey;
import org.monkey.mmq.config.Loggers;
import org.monkey.mmq.core.exception.MmqException;
import org.monkey.mmq.core.utils.LoggerUtils;
import org.monkey.mmq.service.DupPublishMessageStoreService;
import org.monkey.mmq.service.MessageIdService;

/**
 * PUBACK连接处理
 * @author Solley
 */
public class PubAck {

	private MessageIdService messageIdService;

	private DupPublishMessageStoreService dupPublishMessageStoreService;

	public PubAck(MessageIdService messageIdService, DupPublishMessageStoreService dupPublishMessageStoreService) {
		this.messageIdService = messageIdService;
		this.dupPublishMessageStoreService = dupPublishMessageStoreService;
	}

	public void processPubAck(Channel channel, MqttMessageIdVariableHeader variableHeader) throws MmqException {
		int messageId = variableHeader.messageId();
		LoggerUtils.printIfDebugEnabled(Loggers.BROKER_PROTOCOL,"PINGREQ - clientId: {}", "PUBACK - clientId: {}, messageId: {}", (String) channel.attr(AttributeKey.valueOf("clientId")).get(), messageId);
		dupPublishMessageStoreService.delete((String) channel.attr(AttributeKey.valueOf("clientId")).get(), messageId);
		//messageIdService.releaseMessageId(messageId);
	}

}
