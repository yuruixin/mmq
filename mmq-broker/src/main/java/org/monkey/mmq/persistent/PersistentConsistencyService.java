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
package org.monkey.mmq.persistent;

/**
 * A consistency service that guarantee CP consistency for the published data.
 *
 * <p>CP consistency is hereby defined as follows:
 *
 * <p>Once the writing operation returned client a success, the data within the operation is guaranteed to be
 * successfully written to the cluster. And the data should be consistent between servers after some time without any
 * outside interfere.
 *
 * @author solley
 */
public interface PersistentConsistencyService extends ConsistencyService {
    
}
