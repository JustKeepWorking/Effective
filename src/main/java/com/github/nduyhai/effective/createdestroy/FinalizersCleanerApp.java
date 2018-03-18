package com.github.nduyhai.effective.createdestroy;

import java.lang.ref.Cleaner;
import java.lang.ref.Cleaner.Cleanable;

/**
 * Item 8: Avoid finalizers and cleaners
 *
 * - Finalizers are unpredictable, often dangerous, and generally unnecessary (Deprecated in Jdk9)
 *
 * - Cleaners are less dangerous than finalizers, but still unpredictable, slow, and generally
 * unnecessary (Since jdk9)
 *
 * - Never do anything time-critical in a finalizer or cleaner
 *
 * - Never depend on a finalizer or cleaner to update persistent state
 *
 * - There is a severe performance penalty for using finalizers and cleaners
 *
 * - Finalizers have a serious security problem: they open your class up to finalizer attacks
 *
 * - Throwing an exception from a constructor should be sufficient to prevent an object from coming
 * into existence; in the presence of finalizers, it is not
 *
 * -  To protect nonfinal classes from finalizer attacks, write a final finalize method that does
 * nothing
 */
public class FinalizersCleanerApp {

  public static void main(String[] args) {
    try (Room room = new Room("TryCatchRoom")) {
      System.out.println(String.join(" ", "On process....", room.getName()));
    } catch (Exception e) {
      System.out.println(e);
    }

    //The behavior of cleaners during System.exit is implementation specific.
    // No guarantees are made relating to whether cleaning actions are invoked or not.
    final Room notClose = new Room("NoTryRoom");
    System.out.println("Please, close me now!");

    System.gc();
  }

}

class Room implements AutoCloseable {

  private String name;

  public static final Cleaner cleaner = Cleaner.create();
  private Cleanable cleanable;

  private Stage stage;

  public Room(String name) {
    this.name = name;
    this.stage = new Stage(this.name);
    this.cleanable = cleaner.register(this, this.stage);
  }

  private static class Stage implements Runnable {

    private String name;

    public Stage(String name) {
      this.name = name;
    }

    @Override
    public void run() {
      System.out.println(String.join(" ", "On stage of ", this.name));
    }
  }

  @Override
  public void close() {
    System.out.println(String.join(" ", "Closing....", this.name));
    cleanable.clean();
  }

  public String getName() {
    return name;
  }
}
