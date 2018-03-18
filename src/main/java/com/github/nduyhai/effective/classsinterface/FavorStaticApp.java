package com.github.nduyhai.effective.classsinterface;

import com.github.nduyhai.effective.classsinterface.Outer.Inner;

/**
 * Item 24: Favor static member classes over nonstatic
 *
 * There are four kinds of nested classes: static member classes, nonstatic member classes,
 * anonymous classes, and local classes.
 *
 *
 * - If you declare a member class that does not require access to an enclosing instance, always put
 * the static modifier in its declaration
 *
 * - Prefer lambda to Anonymous classes
 */
public class FavorStaticApp {

  public static void main(String[] args) {
    Outer.StaticInner.show();

    final Outer outer = new Outer("Outside");
    final Inner inner = outer.new Inner();
    inner.show();

    outer.test();
  }

}


class Outer {

  private String outerName;

  public Outer(String outerName) {
    this.outerName = outerName;
  }

  static class StaticInner {

    static void show() {
      System.out.println(String.format("From %s show %s", "StaticInner", "null"));

    }
  }

  class Inner {

    public void show() {
      System.out.println(String.format("From %s show %s", "inner", Outer.this.outerName));
    }
  }

  public void test() {
    class Content {

      private String value;
//      private static Integer length; //Cannot do that

      public Content(String value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return "content{" +
            "value='" + value + '\'' +
            '}';
      }
    }

    final Content local_classes = new Content("Local classes");
    System.out.println(local_classes);
  }
}