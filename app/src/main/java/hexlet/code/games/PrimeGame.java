package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public final class PrimeGame {
  private static final String YES = "yes";
  private static final String NO = "no";
  private static final Random RANDOM = new Random();
  public static final int THREE = 3;

  public static void play() {
    QAtuple[] items = new QAtuple[Engine.REQUIRED_WIN_COUNT];
    for (int i = 0; i < Engine.REQUIRED_WIN_COUNT; i++) {
      items[i] = getQAtuple();
    }
    Engine.play(getRules(), items);
  }

  public static String getRules() {
    return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
  }

  public static QAtuple getQAtuple() {
    var number = RANDOM.nextInt(Integer.MAX_VALUE);
    var answer = isPrime(number) ? YES : NO;
    return new QAtuple(String.valueOf(number), answer);
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
    for (int i = THREE; i < sqrt; i += 2) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
