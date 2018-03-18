package com.github.nduyhai.effective.createdestroy;

import java.util.EmptyStackException;

/**
 * Item 7: Eliminate obsolete object references
 *
 * - Nulling out object references should be the exception rather than the norm
 *
 * - Whenever a class manages its own memory, the programmer should be alert for memory leaks
 *
 * - Another common source of memory leaks is caches - A third common source of memory leaks is
 * listeners and other callbacks
 */
public class ObjectReferencesApp {

  public static void main(String[] args) {
    NonLeakStack<String> stack = new NonLeakStack<>();
    stack.push("to");
    stack.push("be");
    stack.push("or");
    stack.push("not");
    stack.push("to be");

    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());

  }

}


class NonLeakStack<T> {

  private Integer size = 0;
  private Integer max = 10;
  private Object[] elements;

  public NonLeakStack() {
    this.elements = new Object[max];
  }

  T pop() {
    if (this.size == 0) {
      throw new EmptyStackException();
    } else {
      Object result = elements[--size];
      elements[size] = null; //Eliminate obsolete reference
      return (T) result;
    }
  }


  void push(T t) {
    if (size + 1 == max) {
      throw new ArrayIndexOutOfBoundsException(this.max);
    } else {
      this.elements[size++] = t;
    }
  }


}