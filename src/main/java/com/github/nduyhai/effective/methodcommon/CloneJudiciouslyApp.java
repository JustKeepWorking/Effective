package com.github.nduyhai.effective.methodcommon;

/**
 * Item 13: Override clone judiciously
 *
 * - In practice, a class implementing Cloneable is expected to provide a properly functioning
 * public clone method
 *
 * - Immutable classes should never provide a clone method
 *
 * - In effect, the clone method functions as a constructor; you must ensure that it does no harm to
 * the original object and that it properly establishes invariants on the clone
 *
 * -  The Cloneable architecture is incompatible with normal use of final fields referring to
 * mutable objects
 *
 * - Public clone methods should omit the throws clause
 *
 * - A better approach to object copying is to provide a copy constructor or copy factory
 */
public class CloneJudiciouslyApp {

  public static void main(String[] args) {
    final House house = new House("King landing");
    System.out.println(house);

    final House newHouse = House.newHouse(house);
    System.out.println(newHouse);

  }

}


class House implements Cloneable {

  private String name;

  public House(String name) {
    this.name = name;
  }

  public House(House house) {
    this.name = house.name;
  }


  public static House newHouse(House old) {
    final House house = new House(old.name);
    return house;
  }

  @Override
  public String toString() {
    return "House{" +
        "name='" + name + '\'' +
        '}';
  }
}