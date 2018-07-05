/*
 * Copyright [2018] [Andy Moncsek]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jacpfx.anemicmodel.traits;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jacpfx.anemicmodel.AnemicModel;
import org.jacpfx.anemicmodel.ValueHolder;
import org.jacpfx.anemicmodel.model.TravelRequests;

public interface Consultant extends AnemicModel {

  Class<TravelRequests> propertyType = TravelRequests.class;


  default TravelRequests getTravelRequests() {
    final ValueHolder valueHolder = getProperties().get(propertyType.getName());
    return valueHolder.getValue(propertyType);
  }


  default Map<String, String> getTravelRequestsMap() {
    final ValueHolder valueHolder = getProperties().get(propertyType.getName());
    return valueHolder.getValue(propertyType).getRequests();
  }

  default void addTravelRequest(String from, String to) {
    final ValueHolder valueHolder = getProperties().get(propertyType.getName());
    Map<String, String> requests = new ConcurrentHashMap<>();
    if (valueHolder != null) {
      requests = new ConcurrentHashMap<>(valueHolder.getValue(propertyType).getRequests());
    }
    requests.put(from, to);
    addProperty(propertyType.getName(),
        new ValueHolder(propertyType, new TravelRequests(requests)));
  }

}
