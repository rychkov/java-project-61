package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public final class GcdGame {
  public static final int BOUND = 100;
  private static final Random RANDOM = new Random();

  public static void play() {
    String[][] items = new String[Engine.REQUIRED_WIN_COUNT][2];
    for (int i = 0; i < Engine.REQUIRED_WIN_COUNT; i++) {
      items[i] = getQAtuple();
    }
    Engine.play(getRules(), items);
  }

  public static String getRules() {
    return "Find the greatest common divisor of given numbers.";
  }

  public static String[] getQAtuple() {
    var number1 = getSmallNumber(BOUND);
    var number2 = getSmallNumber(BOUND);
    var answer = String.valueOf(gcd(number1, number2));

    return new String[]{"%d %d".formatted(number1, number2), answer};
  }

  private static int gcd(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);

    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }

  private static int getSmallNumber(int bound) {
      return RANDOM.nextInt(bound);
  }
}
