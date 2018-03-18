package com.github.nduyhai.effective.classsinterface;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Item 18: Favor composition over inheritance
 */
public class FavorCompositionApp {

  public static void main(String[] args) {
    final FragileLazyHashSet<String> fragile = new FragileLazyHashSet<>();
    fragile.add("2");
    fragile.add("3");
    System.out.println(fragile.getAddCount()); //2

    //This work wrong! Because addAll call Add
    fragile.addAll(Arrays.asList("I", "You"));
    System.out.println(fragile.getAddCount()); //6

    final LazyHashSet<String> lazy = new LazyHashSet<>(new HashSet<>());
    lazy.add("2");
    lazy.add("3");
    System.out.println(lazy.getAddCount()); //2

    //This work wrong! Because addAll call Add
    lazy.addAll(Arrays.asList("I", "You"));
    System.out.println(lazy.getAddCount()); //4
  }

}


class FragileLazyHashSet<E> extends HashSet<E> {

  private int addCount = 0;

  public FragileLazyHashSet() {
  }

  public FragileLazyHashSet(int initialCapacity, float loadFactor) {
    super(initialCapacity, loadFactor);
  }

  @Override
  public boolean add(E e) {
    this.addCount++;
    return super.add(e);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    this.addCount += c.size();
    return super.addAll(c);
  }

  public int getAddCount() {
    return addCount;
  }
}

//Wrapper or Decorator, delegation
class LazyHashSet<E> implements Set<E> {

  private int addCount = 0;

  private Set<E> internalSet;

  public LazyHashSet(Set<E> internalSet) {
    this.internalSet = internalSet;
  }

  @Override
  public int size() {
    return this.internalSet.size();
  }

  @Override
  public boolean isEmpty() {
    return this.internalSet.isEmpty();
  }

  @Override
  public boolean contains(Object o) {
    return this.internalSet.contains(o);
  }

  @Override
  public Iterator<E> iterator() {
    return this.internalSet.iterator();
  }

  @Override
  public Object[] toArray() {
    return this.internalSet.toArray();
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return this.internalSet.toArray(a);
  }

  @Override
  public boolean add(E e) {
    this.addCount++;
    return this.internalSet.add(e);
  }

  @Override
  public boolean remove(Object o) {
    return this.internalSet.remove(o);
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return this.internalSet.containsAll(c);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    this.addCount += c.size();
    return this.internalSet.addAll(c);
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return this.internalSet.retainAll(c);
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return this.internalSet.removeAll(c);
  }

  @Override
  public void clear() {
    this.internalSet.clear();
  }

  public int getAddCount() {
    return addCount;
  }
}