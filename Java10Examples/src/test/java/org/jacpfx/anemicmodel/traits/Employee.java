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

import org.jacpfx.anemicmodel.AnemicModel;
import org.jacpfx.anemicmodel.ValueHolder;
import org.jacpfx.anemicmodel.model.Salary;

public interface Employee extends AnemicModel {

  Class<Salary> propertyType = Salary.class;

  default Salary getSalary() {
    final ValueHolder valueHolder = getProperties().get(propertyType.getName());
    return valueHolder.getValue(propertyType);
  }


  default void addSalery(Salary salery) {
    addProperty(propertyType.getName(), new ValueHolder(propertyType, salery));
  }
}
