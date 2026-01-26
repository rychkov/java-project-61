package hexlet.code.games;

import java.util.Random;

public final class GcdGame implements Game {
  public static final int BOUND = 100;
  private String answer;
  private static final Random RANDOM = new Random();

  @Override
  public String getRules() {
    return "Find the greatest common divisor of given numbers.";
  }

  @Override
  public String getQuestion() {
    var number1 = getSmallNumber(BOUND);
    var number2 = getSmallNumber(BOUND);
    answer = String.valueOf(gcd(number1, number2));

    return "%d %d".formatted(number1, number2);
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
