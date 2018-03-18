package com.github.nduyhai.effective.classsinterface;

/**
 * Item 17: Minimize mutability
 *
 * To make a class immutable, follow these five rules:
 *
 * - Don’t provide methods that modify the object’s state
 *
 * - Ensure that the class can’t be extended
 *
 * - Make all fields final
 *
 * - Make all fields private
 *
 * - Ensure exclusive access to any mutable components
 *
 * Notes:
 *
 * - Immutable objects are inherently thread-safe; they require no synchronization. Immutable
 * objects can be shared freely
 *
 * - Not only can you share immutable objects, but they can share their internals.
 *
 * - Immutable objects make great building blocks for other objects
 *
 * - Immutable objects provide failure atomicity for free
 *
 * - The major disadvantage of immutable classes is that they require a separate object for each
 * distinct value
 *
 * - Classes should be immutable unless there’s a very good reason to make them mutable
 *
 * - If a class cannot be made immutable, limit its mutability as much as possible. Declare every
 * field private final unless there’s a good reason to do otherwise
 *
 * - Constructors should create fully initialized objects with all of their invariants established
 */
public class MinimizeMutabilityApp {

  public static void main(String[] args) {

  }

}
