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

package org.monkey.mmq.service;

import org.monkey.mmq.config.Loggers;
import org.monkey.mmq.core.exception.MmqException;
import org.monkey.mmq.metadata.KeyBuilder;
import org.monkey.mmq.metadata.RecordListener;
import org.monkey.mmq.metadata.UtilsAndCommons;
import org.monkey.mmq.metadata.message.DupPublishMessageMateData;
import org.monkey.mmq.persistent.ConsistencyService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Publish指令
 *
 * @author solley
 */
@Service
public class DupPublishMessageStoreService implements RecordListener<DupPublishMessageMateData> {

    @Resource(name = "persistentConsistencyServiceDelegate")
    private ConsistencyService consistencyService;

    private Map<String, DupPublishMessageMateData> dupPublishMessageStoreMap = new ConcurrentHashMap<>();

    /**
     * Init
     */
    @PostConstruct
    public void init() {
        try {
            consistencyService.listen(KeyBuilder.getPublishStoreKey(), this);
        } catch (MmqException e) {
            Loggers.BROKER_SERVER.error("listen subscribe service failed.", e);
        }
    }

    public List<DupPublishMessageMateData> get(String clientId) {
        return dupPublishMessageStoreMap.entrySet().stream()
                .filter(publish -> publish.getValue().getClientId().equals(clientId))
                .map(publish -> publish.getValue())
                .collect(Collectors.toList());
    }

    public void put(String clientId, DupPublishMessageMateData dupPublishMessageStore) throws MmqException {
        consistencyService.put(UtilsAndCommons.PUBLISH_STORE + clientId + dupPublishMessageStore.getMessageId(), dupPublishMessageStore);
    }

    @Async
    public void delete(String clientId, int messageId) throws MmqException {
        consistencyService.remove(UtilsAndCommons.PUBLISH_STORE + clientId + messageId);
    }

    @Async
    public void deleteForClient(String clientId) {
        try {
            Set<Map.Entry<String, DupPublishMessageMateData>> curDupPublishMessageStore
                    = dupPublishMessageStoreMap.entrySet().stream().filter(message -> message.getValue().getClientId().equals(clientId))
                    .collect(Collectors.toSet());
            curDupPublishMessageStore.forEach(publish -> {
                try {
                    consistencyService.remove(publish.getKey());
                } catch (MmqException e) {
                    Loggers.BROKER_SERVER.error(e.getMessage());
                }
            });
        } catch (Exception e) {
            Loggers.BROKER_SERVER.error(e.getMessage());
        }
    }

    @Override
    public boolean interests(String key) {
            return KeyBuilder.matchPublishKey(key);
    }

    @Override
    public boolean matchUnlistenKey(String key) {
        return KeyBuilder.matchPublishKey(key);
    }

    @Override
    public void onChange(String key, DupPublishMessageMateData value) {
        dupPublishMessageStoreMap.put(key, value);
    }

    @Override
    public void onDelete(String key) {
        dupPublishMessageStoreMap.remove(key);
    }

}
