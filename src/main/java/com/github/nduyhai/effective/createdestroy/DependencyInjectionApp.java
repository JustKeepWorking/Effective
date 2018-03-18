package com.github.nduyhai.effective.createdestroy;

import java.util.Arrays;
import java.util.List;

/**
 * Item 5: Prefer dependency injection to hardwiring resources
 *
 * - Static utility classes and singletons are inappropriate for classes whose behavior is
 * parameterized by an underlying resource
 */
public class DependencyInjectionApp {

  public static void main(String[] args) {
    final SpellChecker spellChecker = new SpellChecker(new EnLexicon());
    final List<String> secret = spellChecker.sugesstions("secret");
    System.out.println(secret);
  }
}


class SpellChecker {

  private Lexicon dictionary;

  //Inject
  public SpellChecker(Lexicon dictionary) {
    this.dictionary = dictionary;
  }

  public boolean isValid(String word) {
    return false;
  }

  public List<String> sugesstions(String typo) {
    return this.dictionary.suggestions(typo);
  }
}


interface Lexicon {

  List<String> suggestions(String typo);
}

class EnLexicon implements Lexicon {

  @Override
  public List<String> suggestions(String typo) {
    return Arrays.asList("No", "Thing", "Imposiple");
  }
}