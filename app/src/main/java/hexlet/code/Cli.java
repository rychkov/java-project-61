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
  }

  /**
   * Read user name.
   * @return user name
   */
  public static String readName() {
    var name = readString();
    System.out.printf("Hello, %s!%n", name);
    return name;
  }

  /**
   * Read string from console.
   * @return string
   */
  public static String readString() {
    Scanner scanner = new Scanner(System.in);
    return scanner.next();
  }

  /**
   * Read int from console.
   * @return value
   */
  public static int readInt() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }
}
