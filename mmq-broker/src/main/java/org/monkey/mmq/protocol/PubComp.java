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
import org.monkey.mmq.service.DupPubRelMessageStoreService;
import org.monkey.mmq.service.MessageIdService;

/**
 * PUBCOMP连接处理
 * @author Solley
 */
public class PubComp {

	private MessageIdService messageIdService;

	private DupPubRelMessageStoreService dupPubRelMessageStoreService;

	public PubComp(MessageIdService messageIdService, DupPubRelMessageStoreService dupPubRelMessageStoreService) {
		this.messageIdService = messageIdService;
		this.dupPubRelMessageStoreService = dupPubRelMessageStoreService;
	}

	public void processPubComp(Channel channel, MqttMessageIdVariableHeader variableHeader) throws MmqException {
		int messageId = variableHeader.messageId();
		LoggerUtils.printIfDebugEnabled(Loggers.BROKER_PROTOCOL,"PUBCOMP - clientId: {}, messageId: {}", (String) channel.attr(AttributeKey.valueOf("clientId")).get(), messageId);
		dupPubRelMessageStoreService.delete((String) channel.attr(AttributeKey.valueOf("clientId")).get(), variableHeader.messageId());
		// messageIdService.releaseMessageId(messageId);
	}
}
