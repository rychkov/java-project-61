package hexlet.code.games;

import hexlet.code.Cli;
import java.util.Random;
import java.util.function.Predicate;

public final class EvenGame implements Game {
  private static final int REQUIRED_WIN_COUNT = 3;
  private static final String YES = "yes";
  private static final String NO = "no";
  private static final Random RANDOM = new Random();

  public void play(final String name) {
    int winCount = 0;
    System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    do {
      int number = RANDOM.nextInt();

      System.out.println("Question: " + number);
      System.out.print("Your answer: ");
      var input = Cli.readString();

      boolean evenNumber = isEven.test(number);
      if ((evenNumber && YES.equalsIgnoreCase(input))
          || (!evenNumber && NO.equalsIgnoreCase(input))) {
        winCount++;
        System.out.println("Correct!");
      } else {
        System.out.println(
                "'%s' is wrong answer ;(. Correct answer was '%s' ".formatted(input, getIsEvenString(number))
        );
        System.out.printf("Let's try again, %s!%n", name);
        break;
      }
    } while (winCount < REQUIRED_WIN_COUNT);
    if (winCount == REQUIRED_WIN_COUNT) {
      System.out.printf("Congratulations, %s!%n", name);
    }
  }

  private static String getIsEvenString(int number) {
    return isEven.test(number) ? YES : NO;
  }

  private static Predicate<Integer> isEven = i -> i % 2 != 0;
}
