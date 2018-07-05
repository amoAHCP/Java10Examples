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

package org.jacpfx.anemicmodel.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Expenses {

  private final Map<String, String> expenses;

  public Expenses(Map<String, String> expenses) {
    this.expenses = expenses;
  }

  public Expenses() {
    expenses = new ConcurrentHashMap<>();
  }

  public Expenses(String when, String howmuch) {
    expenses = new ConcurrentHashMap<>();
    expenses.put(when, howmuch);
  }

  public Map<String, String> getExpenses() {
    return expenses;
  }
}
