package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public final class PrimeGame {
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
    return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
  }

  public static String[] getQAtuple() {
    var number = RANDOM.nextInt(Integer.MAX_VALUE);
    var answer = isPrime(number) ? YES : NO;
    return new String[]{String.valueOf(number), answer};
  }

  private static boolean isPrime(int number) {
    if (number < 2) {
      return false;
    }
    if (number == 2) {
      return true;
    }
    if (number % 2 == 0) {
      return false;
    }
    var sqrt = Math.round(Math.sqrt(number));
    final int three = 3;
    for (int i = three; i < sqrt; i += 2) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
