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


import java.util.Arrays;
import java.util.List;
import org.junit.Test;

interface Superfruit {

  String name();

  List<String> getVitamins();
}

@FunctionalInterface
interface SuperfruitDelegate extends Superfruit {

  Superfruit instance();

  default String name() {
    return instance().name();
  }

  default List<String> getVitamins() {
    return instance().getVitamins();
  }
}


interface Banana extends Superfruit {

  String VITAMIN = "vitamin c";

  default boolean containsVitaminC() {
    return getVitamins().contains(VITAMIN);
  }
}

interface Orange extends Superfruit {

  String VITAMIN = "vitamin b";

  default boolean containsVitaminB() {
    return getVitamins().contains(VITAMIN);
  }
}

public class TraitExample {

  private SuperfruitDelegate fruit;

  @Test
  public void testPseudotraits() {
    Superfruit myFruit = new MySuperfruit("OrangeBanana", "vitamin c", "vitamin b", "vitamin d");
    var fruit = (SuperfruitDelegate & Banana & Orange) () -> myFruit;
    System.out.println(
        "This is the fruit: " + fruit.name() + " it contains vitamin c: " + fruit.containsVitaminC()
            + " and vitamin b: " + fruit.containsVitaminB());
  }

  @Test
  public void testPseudotraits2() {
    Superfruit myFruit = new MySuperfruit("OrangeBanana", "vitamin c", "vitamin b", "vitamin d");
    var fruit = (SuperfruitDelegate & Banana & Orange) () -> myFruit;
    print(fruit);
  }

  @Test
  public void testPseudotraits3() {
    Superfruit myFruit = new MySuperfruit("OrangeBanana", "vitamin c", "vitamin b", "vitamin d");
    var banana = (SuperfruitDelegate & Banana) () -> myFruit;
    System.out.println("This is the fruit: " + banana.name() + " it contains vitamin c: " + banana
        .containsVitaminC());

    var orange = (SuperfruitDelegate & Orange) () -> myFruit;
    System.out.println("This is the fruit: " + orange.name() + " it contains vitamin b: " + orange
        .containsVitaminB());

    var superfruit = (SuperfruitDelegate & Banana & Orange) () -> myFruit;
    print(superfruit);
  }

  @Test(expected = ClassCastException.class)
  public void testCast() {
    Superfruit myFruit = new MySuperfruit("OrangeBanana", "vitamin c", "vitamin b", "vitamin d");
    Banana banana = Banana.class.cast(myFruit);
    System.out.println("This is the fruit: " + banana.name() + " it contains vitamin c: " + banana
        .containsVitaminC());

  }


  public <A extends SuperfruitDelegate & Banana & Orange> void print(A fruit) {
    System.out.println(
        "This is the fruit: " + fruit.name() + " it contains vitamin c: " + fruit.containsVitaminC()
            + " and vitamin b: " + fruit.containsVitaminB());

  }

}

class MySuperfruit implements Superfruit {

  String name;
  String[] vitamins;

  public MySuperfruit(String name, String... vitamins) {
    this.name = name;
    this.vitamins = vitamins;
  }

  @Override
  public String name() {
    return this.name;
  }

  @Override
  public List<String> getVitamins() {
    return Arrays.asList(this.vitamins);
  }
}