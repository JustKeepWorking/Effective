package com.github.nduyhai.effective.createdestroy;

/**
 * Item 1: Consider static factory methods instead of constructors
 *
 * - They have names. - They are not required to create a new object each time they’re invoked
 *
 * - They can return an object of any subtype of their return type
 *
 * - The class of the returned object can vary from call to call as a function of the input
 * parameters
 *
 * - The returned object need not exist when the class containing the method is written
 *
 * * Limitation
 *
 * - Classes without public or protected constructors cannot be subclassed
 *
 * - Hard for programmers to find
 */
public class StaticFactoryApp {

  public static void main(String[] args) {
    System.setProperty("CleanServiceImpl", CleanServiceImpl.class.getName());
    final CleanService cleanService = ServiceFactory.cleanService();
    cleanService.clean();
  }
}


interface CleanService {

  void clean();
}

class ServiceFactory {

  public static CleanService cleanService() {
    try {
      return (CleanService) Class.forName(System.getProperty("CleanServiceImpl"))
          .getDeclaredConstructor().newInstance();
    } catch (Throwable t) {
      throw new Error(t);
    }
  }
}

class CleanServiceImpl implements CleanService {

  public void clean() {
    System.out.println(
        "The returned object need not exist when the class containing the method is written");
    System.out.println("Cleaning.....");
  }
}
