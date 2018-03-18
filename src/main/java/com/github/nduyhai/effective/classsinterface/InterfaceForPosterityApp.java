package com.github.nduyhai.effective.classsinterface;

/**
 * Item 21: Design interfaces for posterity
 *
 * - it is not always possible to write a default method that maintains all invariants of every
 * conceivable implementation
 *
 * - In the presence of default methods, existing implementations of an interface may compile
 * without error or warning but fail at runtime
 *
 * -  it is still of the utmost importance to design interfaces with great care
 */
public class InterfaceForPosterityApp {

  public static void main(String[] args) {
    final Greeting greeting = new Greeting() {
    };

    greeting.say();

  }

}


interface Greeting {

  default void say() {
    System.out.println("Hello!");
  }
}