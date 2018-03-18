package com.github.nduyhai.effective.createdestroy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Item 3: Enforce the singleton property with a private constructor or an enum type
 */
public class SingletonPropertyApp {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    System.out.println(Person.person);
    System.out.println(Society.getSociety());

    //Serializable Singleton
    final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    final ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
    objectOutputStream.writeObject(Person.person);
    objectOutputStream.close();

    Society.getSociety().setName("HYBEN");

    final InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    final ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
    Person person = (Person) objectInputStream.readObject();
    System.out.println(person); //Suri

    //Serializable Singleton with replace current instant serializable
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    final ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(Society.getSociety());
    oos.close();

    Society.getSociety().setName("King of snow");

    InputStream is = new ByteArrayInputStream(baos.toByteArray());
    ObjectInputStream ois = new ObjectInputStream(is);
    Society society = (Society) ois.readObject();
    System.out.println(society); //King of snow


  }
}

class Person implements Serializable {

  private String name;
  public static Person person = new Person();

  private Person() {
    this.name = "Suri";
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        '}';
  }

  public void setName(String name) {
    this.name = name;
  }

  private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
    ois.defaultReadObject();
    person = this;
  }


}

class Society implements Serializable {

  private String name;
  private static Society society = new Society();

  private Society() {
    this.name = "King";
  }

  public static Society getSociety() {
    return society;
  }

  @Override
  public String toString() {
    return "Society{" +
        "name='" + name + '\'' +
        '}';
  }

  public void setName(String name) {
    this.name = name;
  }


  private Object readResolve() {
    // Return the one true Elvis and let the garbage collector
    // take care of the Elvis impersonator.
    return society;
  }
}