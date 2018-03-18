package com.github.nduyhai.effective.createdestroy;

import java.util.regex.Pattern;

/**
 * Item 6: Avoid creating unnecessary objects
 *
 * - Prefer primitives to boxed primitives, and watch out for unintentional autoboxing
 */
public class AvoidCreateUnnecessaryApp {

  public static void main(String[] args) {
    String imu = new String("imuate"); // Don't do that
  }
}

// Reusing expensive object for improved performance
class RomanNumerals {

  private RomanNumerals() {
  }

  private static final Pattern ROMAN = Pattern.compile(
      "^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

  public static boolean isRomanNumeral(String s) {
    return ROMAN.matcher(s).matches(); // Use this replace s.match("pattern")
  }
}
