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

public class ValueHolder {

  private final Class type;
  private final Object value;

  public ValueHolder(Class type, Object value) {
    this.type = type;
    this.value = value;
  }

  public <A> A getValue(Class<A> clazz) {
    return clazz.cast(value);
  }

  public Class getType() {
    return type;
  }
}
