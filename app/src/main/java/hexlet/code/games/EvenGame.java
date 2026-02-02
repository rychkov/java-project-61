package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.function.Predicate;

public final class EvenGame {
  private static final String YES = "yes";
  private static final String NO = "no";
  private static final Random RANDOM = new Random();

  public static void play() {
    String[][] items = new String[Engine.REQUIRED_WIN_COUNT][2];
    for (int i = 0; i < Engine.REQUIRED_WIN_COUNT; i++) {
      items[i] = getQAtuple();
    }
    Engine.play(getRules(), items);
  }

  public static String getRules() {
    return "Answer 'yes' if the number is even, otherwise answer 'no'.";
  }

  private static final Predicate<Integer> IS_EVEN = i -> i % 2 == 0;

  public static String[] getQAtuple() {
    int number = RANDOM.nextInt();
    return new String[]{String.valueOf(number), IS_EVEN.test(number) ? YES : NO};
  }
}
