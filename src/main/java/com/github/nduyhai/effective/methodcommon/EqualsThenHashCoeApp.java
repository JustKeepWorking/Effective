package com.github.nduyhai.effective.methodcommon;

import java.util.List;
import java.util.Objects;

/**
 * Item 11: Always override hashCode when you override equals
 *
 * - You must override hashCode in every class that overrides equals.
 *
 * - must consistently return the same value
 *
 * - 2 object equals => 2 object have same hashCode
 *
 * - Equal objects must have equal hash codes
 *
 * - Do not be tempted to exclude significant fields from the hash code computation to improve
 * performance
 *
 * - Don’t provide a detailed specification for the value returned by hashCode, so clients can’t
 * reasonably depend on it; this gives you the flexibility to change it
 */
public class EqualsThenHashCoeApp {

  public static void main(String[] args) {

  }

}

class Book {

  private String author;

  private String title;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(author, book.author) &&
        Objects.equals(title, book.title);
  }

  @Override
  public int hashCode() {

    return Objects.hash(author, title);
  }
}

class BookStore {

  private String name;

  private List<Book> books;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookStore bookStore = (BookStore) o;
    return Objects.equals(name, bookStore.name) &&
        Objects.equals(books, bookStore.books);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name, books);
  }
}