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
import org.jacpfx.anemicmodel.model.Expenses;
import org.jacpfx.anemicmodel.model.Salary;
import org.jacpfx.anemicmodel.model.Url;

public interface Manager extends AnemicModel {

  Class<Url> propertyType = Url.class;
  Class<Salary> propertyType2 = Salary.class;

  default Expenses getExpenses() {
    final ValueHolder valueHolder = getProperties().get(propertyType.getName());
    String url = valueHolder.getValue(propertyType).getUrl();
    // do some Rest request
    return new Expenses("today", "a lot of");
  }

  default boolean isManager() {
    final ValueHolder valueHolder = getProperties().get(propertyType2.getName());
    if (valueHolder != null) {
      final Salary salary = valueHolder.getValue(propertyType2);
      if (salary.getAmount() > 500000) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }


}
