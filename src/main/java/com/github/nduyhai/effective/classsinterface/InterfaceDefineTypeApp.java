package com.github.nduyhai.effective.classsinterface;

/**
 * Item 22: Use interfaces only to define types
 *
 * - The constant interface pattern is a poor use of interfaces
 *
 * -  interfaces should be used only to define types. They should not be used merely to export
 * constants
 */
public class InterfaceDefineTypeApp {

  public static void main(String[] args) {

  }

}

//Should make constant to Utility class or Enum
interface NotDoThis {

  static final Integer VALUE = 2;
}