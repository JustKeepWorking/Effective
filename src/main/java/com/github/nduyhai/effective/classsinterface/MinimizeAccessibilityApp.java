package com.github.nduyhai.effective.classsinterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Item 15: Minimize the accessibility of classes and members
 *
 * - Make each class or member as inaccessible as possible
 *
 * - Instance fields of public classes should rarely be public
 *
 * - Classes with public mutable fields are not generally thread-safe
 *
 * - Note that a nonzero-length array is always mutable, so it is wrong for a class to have a public
 * static final array field, or an accessor that returns such a field
 */
public class MinimizeAccessibilityApp {

  public static void main(String[] args) {

    NoOneOutside.getValues()[2] = "John Snow";
    assert NoOneOutside.getValues()[2] != NoOneOutside.VALUES.get(2);

    //Throws UnsupportedOperationException
    NoOneOutside.VALUES.add("Cannot do this");


  }

}

class NoOneOutside {

  private static final String[] ARRAY_VALUES = {"Me", "You", "No one else"};

  //Expose safe public members
  public static final List<String> VALUES = Collections
      .unmodifiableList(Arrays.asList(ARRAY_VALUES));


  public static String[] getValues() {
    return ARRAY_VALUES.clone();
  }
}