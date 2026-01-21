package hexlet.code;

import java.util.Scanner;

public final class Cli {

  private Cli() {
  }

  /**
   * Show greetings.
   */
  public static void showGreeting() {
    System.out.println("Welcome to the Brain Games!");
    System.out.println("May I have your name?");
    System.out.printf("Hello, %s!%n", readName());
  }

  /**
   * Read name from console.
   * @return name
   */
  static String readName() {
    Scanner scanner = new Scanner(System.console().reader());
    return scanner.next();
  }
}
