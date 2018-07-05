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

package org.jacpfx.anemicmodel;

import java.util.Map;

@FunctionalInterface
public interface AnemicModelDelegate extends AnemicModel {

  AnemicModel instance();

  default Long getId() {
    return instance().getId();
  }

  default String getName() {
    return instance().getName();
  }

  default Map<String, ValueHolder> getProperties() {
    return instance().getProperties();
  }

  default void addProperty(String key, ValueHolder value) {
    instance().addProperty(key, value);
  }

}
