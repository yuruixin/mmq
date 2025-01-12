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

/**
 * 会话存储
 *
 * @author solley
 */

import org.monkey.mmq.config.Loggers;
import org.monkey.mmq.core.consistency.SerializeFactory;
import org.monkey.mmq.core.consistency.Serializer;
import org.monkey.mmq.core.exception.ErrorCode;
import org.monkey.mmq.core.exception.KvStorageException;
import org.monkey.mmq.core.exception.MmqException;
import org.monkey.mmq.core.storage.kv.MemoryKvStorage;
import org.monkey.mmq.core.utils.ByteUtils;
import org.monkey.mmq.metadata.KeyBuilder;
import org.monkey.mmq.metadata.RecordListener;
import org.monkey.mmq.metadata.UtilsAndCommons;
import org.monkey.mmq.metadata.message.ClientMateData;
import org.monkey.mmq.metadata.message.SessionMateData;
import org.monkey.mmq.metadata.subscribe.SubscribeMateData;
import org.monkey.mmq.metadata.system.SystemInfoMateData;
import org.monkey.mmq.persistent.ConsistencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

@Service
public class SessionStoreService implements RecordListener<ClientMateData> {

    @Resource(name = "persistentConsistencyServiceDelegate")
    private ConsistencyService consistencyService;

    @Autowired
    private SystemInfoStoreService systemInfoStoreService;

    private final Map<String, SessionMateData> storage = new ConcurrentSkipListMap<>();

    private final Map<String, ClientMateData> clientStory = new ConcurrentSkipListMap<>();

    /**
     * Init
     */
    @PostConstruct
    public void init() {
        try {
            consistencyService.listen(KeyBuilder.getSessionStoreKey(), this);
        } catch (MmqException e) {
            Loggers.BROKER_SERVER.error("listen Session service failed.", e);
        }
    }

    public Collection<ClientMateData> getClients() {
        return clientStory.values();
    }

    public void put(String clientId, SessionMateData sessionStore) throws MmqException {
        storage.put(clientId, sessionStore);
        InetSocketAddress ipSocket = (InetSocketAddress)sessionStore.getChannel().remoteAddress();
        String clientIp = ipSocket.getAddress().getHostAddress();
        consistencyService.put(UtilsAndCommons.SESSION_STORE + "/" + clientId, new ClientMateData(clientId, sessionStore.getUser(), clientIp));
    }

    public SessionMateData get(String clientId) {
        return storage.get(clientId);
    }

    public boolean containsKey(String clientId) {
        return storage.containsKey(clientId);
    }

    public void delete(String clientId) throws MmqException {
        storage.remove(clientId);
        consistencyService.remove(UtilsAndCommons.SESSION_STORE + "/" + clientId);
    }

    @Override
    public boolean interests(String key) {
        return KeyBuilder.matchSessionStoreKey(key);
    }

    @Override
    public boolean matchUnlistenKey(String key) {
        return KeyBuilder.matchSessionStoreKey(key);
    }

    @Override
    public void onChange(String key, ClientMateData value) throws Exception {
        clientStory.put(key, value);

        SystemInfoMateData systemInfoMateData = systemInfoStoreService.getSystemInfo();
        systemInfoMateData.setClientCount(storage.size());
        systemInfoStoreService.put(systemInfoMateData);
    }

    @Override
    public void onDelete(String key) throws Exception {
        clientStory.remove(key);

        SystemInfoMateData systemInfoMateData = systemInfoStoreService.getSystemInfo();
        systemInfoMateData.setClientCount(clientStory.size());
        systemInfoStoreService.put(systemInfoMateData);
    }
}
