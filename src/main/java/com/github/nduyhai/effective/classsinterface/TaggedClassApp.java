package com.github.nduyhai.effective.classsinterface;

/**
 * Item 23: Prefer class hierarchies to tagged classes
 *
 * - tagged classes are verbose, error-prone, and inefficient
 *
 * - A tagged class is just a pallid imitation of a class hierarchy
 */
public class TaggedClassApp {

  public static void main(String[] args) {
    final TagClass begin = new TagClass("BEGIN");
    begin.greeting();

    final TagHierarchy afterTag = new AfterTag();
    afterTag.greeting();
  }

}

//Don't do this
class TagClass {

  public TagClass(String name) {
    this.current = Tag.valueOf(name);
  }

  enum Tag {
    BEGIN, AFTER;
  }

  private Tag current;

  private String beginHello = "Nice to meet you";

  private String afterHello = "How are you!";


  void greeting() {
    switch (current) {
      case AFTER:
        System.out.println(afterHello);
        break;
      case BEGIN:
        System.out.println(beginHello);
        break;
      default:
        System.out.println("");
    }
  }
}

interface TagHierarchy {

  void greeting();
}

class BeginTag implements TagHierarchy {

  @Override
  public void greeting() {
    System.out.println("Nice to meet you");
  }
}


class AfterTag implements TagHierarchy {

  @Override
  public void greeting() {
    System.out.println("How are you!");
  }
}


