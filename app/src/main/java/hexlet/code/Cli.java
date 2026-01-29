package hexlet.code;

import java.util.Scanner;

public final class Cli {

  public static final Scanner SCANNER = new Scanner(System.in);

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
    return SCANNER.next();
  }

  /**
   * Read int from console.
   * @return value
   */
  public static int readInt() {
    do {
      if (SCANNER.hasNextInt()) {
        var value = SCANNER.nextInt();
        System.out.println("> Input -> " + value);
        return value;
      } else {
        //Skip non int input
        System.out.println("> Unexpected input -> " + SCANNER.next());
      }
    } while (true);
  }
}
