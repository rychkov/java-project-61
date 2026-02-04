package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public final class CalcGame {
  public static final int BOUND = 100;
  private static final String[] OPERATIONS = {"+", "-", "*"};
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
    var opCode = getSmallNumber(OPERATIONS.length);
    String answer = getAnswer(number1, number2, OPERATIONS[opCode]);
    return new String[]{"%d %s %d".formatted(number1, OPERATIONS[opCode], number2), answer};
  }

  private static String getAnswer(int number1, int number2, String operation) {
      return switch (operation) {
          case "+" -> String.valueOf(number1 + number2);
          case "-" -> String.valueOf(number1 - number2);
          case "*" -> String.valueOf(number1 * number2);
          default -> throw new UnsupportedOperationException("Unsupported opCode " + operation);
      };
  }

  private static int getSmallNumber(int bound) {
      return RANDOM.nextInt(bound);
  }
}
