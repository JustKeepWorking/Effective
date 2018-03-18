package com.github.nduyhai.effective.classsinterface;

/**
 * Item 16: In public classes, use accessor methods, not public fields
 *
 * - if a class is accessible outside its package, provide accessor methods
 *
 * -  if a class is package-private or is a private nested class, there is nothing inherently wrong
 * with exposing its data field
 */
public class UseAccessorMethodsApp {

  public static void main(String[] args) {

  }

}

/**
 * public classes should never expose mutable fields.
 *
 * It is less harmful, though still questionable, for public classes to expose immutable fields.
 *
 * It is, however, sometimes desirable for package-private or private nested classes to expose
 * fields, whether mutable or immutable
 */
class Point {

  private double x;

  private double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }
}