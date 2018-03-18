package com.github.nduyhai.effective.classsinterface;

/**
 * Item 20: Prefer interfaces to abstract classes
 *
 * - Existing classes can easily be retrofitted to implement a new interface
 *
 * - Interfaces are ideal for defining mixins
 *
 * - Interfaces allow for the construction of nonhierarchical type frameworks
 *
 * - Interfaces enable safe, powerful functionality enhancements
 *
 * - Good documentation is absolutely essential in a skeletal implementation
 */
public class PreferInterfaceApp {

  public static void main(String[] args) {

//    an interface is generally the best way to define a type that
//permits multiple implementations. If you export a nontrivial interface, you should
//strongly consider providing a skeletal implementation to go with it. To the extent
//possible, you should provide the skeletal implementation via default methods on
//the interface so that all implementors of the interface can make use of it. That said,
//restrictions on interfaces typically mandate that a skeletal implementation take the
//form of an abstract class

  }

}

interface Singer {

  void sing(String song);
}

interface Composer {

  String compose();
}

interface MultitaskUser extends Singer, Composer {

}

//skeletal implementation
abstract class AbstractUser implements MultitaskUser {

  @Override
  public void sing(String song) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String compose() {
    throw new UnsupportedOperationException();
  }
}