package com.github.nduyhai.effective.methodcommon;

import java.util.Comparator;

/**
 * Item 14: Consider implementing Comparable
 *
 * - Reflexive
 *
 * - Symmetric
 *
 * - Transitive
 *
 * Note:
 *
 * - Use of the relational operators < and > in compareTo methods is verbose and error-prone and no
 * longer recommended
 */
public class ComparableApp {

  public static void main(String[] args) {
    final Price p1 = new Price(2);
    final Price p2 = new Price(3);

    System.out.println(COMPARATOR.compare(p1, p2));
    System.out.println(p1.compareTo(p2));
  }

  private static final Comparator<Price> COMPARATOR = (o1, o2) -> Integer
      .compare(o1.getCurrent(), o2.getCurrent());
}

class Price implements Comparable<Price> {

  private Integer current;

  public Price(Integer current) {
    this.current = current;
  }

  public Integer getCurrent() {
    return current;
  }

  @Override
  public int compareTo(Price o) {
    return Integer.compare(this.current, o.current);
  }

  @Override
  public String toString() {
    return "Price{" +
        "current=" + current +
        '}';
  }
}

