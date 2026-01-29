package hexlet.code.games;

import java.util.Random;

public final class CalcGame implements Game {
  public static final int BOUND = 100;
  public static final int OP_BOUND = 3;
  private String answer;
  private static final Random RANDOM = new Random();

  @Override
  public String getRules() {
    return "What is the result of the expression?";
  }

  @Override
  public String getQuestion() {
    var number1 = getSmallNumber(BOUND);
    var number2 = getSmallNumber(BOUND);
    var opCode = getSmallNumber(OP_BOUND);
    String opSymbol;
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
    return "%d %s %d".formatted(number1, opSymbol, number2);
  }

  private int getSmallNumber(int bound) {
      return RANDOM.nextInt(bound);
  }

  @Override
  public boolean isValidInput(String value) {
    return answer.equals(value);
  }

  @Override
  public String getCorrectAnswer() {
    return answer;
  }
}
