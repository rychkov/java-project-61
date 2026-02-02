package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public final class CalcGame {
  public static final int BOUND = 100;
  public static final int OP_BOUND = 3;
  private static final Random RANDOM = new Random();

  public static void play() {
    String[][] items = new String[Engine.REQUIRED_WIN_COUNT][2];
    for (int i = 0; i < Engine.REQUIRED_WIN_COUNT; i++) {
      items[i] = getQAtuple();
    }
    Engine.play(getRules(), items);
  }

  public static String getRules() {
    return "What is the result of the expression?";
  }

  public static String[] getQAtuple() {
    var number1 = getSmallNumber(BOUND);
    var number2 = getSmallNumber(BOUND);
    var opCode = getSmallNumber(OP_BOUND);
    String opSymbol;
    String answer;
    switch (opCode) {
      case 0 -> {
        opSymbol = "+";
        answer = String.valueOf(number1 + number2);
      }
      case 1 -> {
        opSymbol = "-";
        answer = String.valueOf(number1 - number2);
      }
      case 2 -> {
        opSymbol = "*";
        answer = String.valueOf(number1 * number2);
      }
      default -> throw new UnsupportedOperationException("Unsupported opCode " + opCode);
    }
    return new String[]{"%d %s %d".formatted(number1, opSymbol, number2), answer};
  }

  private static int getSmallNumber(int bound) {
      return RANDOM.nextInt(bound);
  }
}
