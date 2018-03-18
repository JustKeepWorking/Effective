package com.github.nduyhai.effective.classsinterface;

/**
 * Item 25: Limit source files to a single top-level class
 *
 * - Never put multiple top-level classes or interfaces in a single source file
 *
 * - Static member classes instead of multiple top-level classes
 */
public class LimitResourceApp {

  public static void main(String[] args) {
    System.out.println(Example.message);
  }

  static class Example {

    static String message = "With me: Just put all class into 1 file in example code for more readability & overview";
  }

}
