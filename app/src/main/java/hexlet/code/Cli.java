package hexlet.code;

import java.util.Scanner;

public class Cli {

  public static void showGreeting() {
    System.out.println("Welcome to the Brain Games!");
    System.out.println("May I have your name?");
    System.out.printf("Hello, %s!%n", readName());
  }

  static String readName() {
    Scanner scanner = new Scanner(System.console().reader());
    return scanner.next();
  }

}
