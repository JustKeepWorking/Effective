package com.github.nduyhai.effective.createdestroy;

import static com.github.nduyhai.effective.createdestroy.NyPizza.Size.SMALL;
import static com.github.nduyhai.effective.createdestroy.Pizza.Topping.HAM;
import static com.github.nduyhai.effective.createdestroy.Pizza.Topping.ONION;
import static com.github.nduyhai.effective.createdestroy.Pizza.Topping.SAUSAGE;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Item 2: Consider a builder when faced with many constructor parameters
 *
 * - The telescoping constructor pattern works, but it is hard to write client code when there are
 * many parameters, and harder still to read it
 *
 * - The Builder pattern simulates named optional parameters - Good choice when designing classes
 * whose constructors or static factories would have more than a handful of parameters
 */
public class BuilderApp {

  public static void main(String[] args) {
    NyPizza pizza = new NyPizza
        .Builder(SMALL)
        .addTopping(SAUSAGE)
        .addTopping(ONION).build();
    Calzone calzone = new Calzone.Builder()
        .addTopping(HAM)
        .sauceInside()
        .build();

    System.out.println(calzone);
    System.out.println(pizza);
  }
}


// Builder pattern for class hierarchies
abstract class Pizza {

  public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

  final Set<Topping> toppings;

  abstract static class Builder<T extends Builder<T>> {

    EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

    public T addTopping(Topping topping) {
      toppings.add(Objects.requireNonNull(topping));
      return self();
    }

    abstract Pizza build();

    // Subclasses must override this method to return "this"
    protected abstract T self();
  }

  Pizza(Builder<?> builder) {
    toppings = builder.toppings.clone(); // See Item 50
  }
}

class NyPizza extends Pizza {

  public enum Size {SMALL, MEDIUM, LARGE}

  private final Size size;

  public static class Builder extends Pizza.Builder<Builder> {

    private final Size size;

    public Builder(Size size) {
      this.size = Objects.requireNonNull(size);
    }

    @Override
    public NyPizza build() {
      return new NyPizza(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }

  private NyPizza(Builder builder) {
    super(builder);
    size = builder.size;
  }

  @Override
  public String toString() {
    return "NyPizza{" +
        "toppings=" + toppings +
        ", size=" + size +
        '}';
  }
}

class Calzone extends Pizza {

  private final boolean sauceInside;

  public static class Builder extends Pizza.Builder<Builder> {

    private boolean sauceInside = false; // Default

    public Builder sauceInside() {
      sauceInside = true;
      return this;
    }

    @Override
    public Calzone build() {
      return new Calzone(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }

  private Calzone(Builder builder) {
    super(builder);
    sauceInside = builder.sauceInside;
  }

  @Override
  public String toString() {
    return "Calzone{" +
        "toppings=" + toppings +
        ", sauceInside=" + sauceInside +
        '}';
  }
}