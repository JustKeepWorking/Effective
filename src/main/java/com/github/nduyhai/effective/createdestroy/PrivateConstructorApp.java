package com.github.nduyhai.effective.createdestroy;

/**
 * Item 4: Enforce noninstantiability with a private constructor
 *
 * - Attempting to enforce noninstantiability by making a class abstract does not work
 */
public class PrivateConstructorApp {

  public static void main(String[] args) {

  }
}

//Noninstantiable utility class
//Don't need mark: final
class Utils {

  // Suppress default constructor for noninstantiability
  private Utils() {
    throw new AssertionError(); //Prevent constructor invoked from within the class
  }
}
