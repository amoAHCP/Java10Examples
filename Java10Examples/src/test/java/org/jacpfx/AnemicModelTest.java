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

package org.jacpfx;

import org.jacpfx.anemicmodel.AnemicModel;
import org.jacpfx.anemicmodel.AnemicModelDelegate;
import org.jacpfx.anemicmodel.model.AnemicModelObject;
import org.jacpfx.anemicmodel.model.Salary;
import org.jacpfx.anemicmodel.traits.CodeMonkey;
import org.jacpfx.anemicmodel.traits.Consultant;
import org.jacpfx.anemicmodel.traits.Employee;
import org.jacpfx.anemicmodel.traits.Manager;
import org.junit.Before;
import org.junit.Test;

public class AnemicModelTest {

  AnemicModel model;

  @Before
  public void setUp() {
    model = new AnemicModelObject(1L, "John Doe");
  }

  @Test
  public void testEmployee() {
    var employee = (AnemicModelDelegate & Employee) () -> model;
    employee.addSalery(new Salary(100L));

    print(employee);
  }

  private void print(Employee employee) {
    System.out.println(
        "the Employee: " + employee.getId() + " with name: " + employee.getName() + " and a salary:"
            + employee.getSalary().getAmount());
  }

  @Test
  public void testConsultant() {
    var consultant = (AnemicModelDelegate & Employee & Consultant) () -> model;
    consultant.addSalery(new Salary(100L));
    consultant.addTravelRequest("Zuerich", "Basel");

    System.out.println(
        "the consultant: " + consultant.getId() + " with name: " + consultant.getName()
            + " and a salary:" + consultant.getSalary().getAmount() + "  and travel requests: "
            + consultant.getTravelRequestsMap());
  }

  @Test
  public void testManagerOrCodeMonkey() {
    var consultant = (AnemicModelDelegate & Employee & Consultant) () -> model;
    consultant.addSalery(new Salary(10000L));
    consultant.addTravelRequest("Zuerich", "Basel");

    var manager = (AnemicModelDelegate & Manager) () -> consultant;
    print(manager);

    var codeMonkey = (AnemicModelDelegate & CodeMonkey) () -> manager;
    print(codeMonkey);
  }

  private void print(Manager manager) {
    System.out.println("is manager? : " + manager.isManager());
  }

  private void print(CodeMonkey codeMonkey) {
    System.out.println("is code monkey? : " + codeMonkey.isCodeMonkey());
  }
}
