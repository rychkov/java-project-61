package hexlet.code.games;

import java.util.Random;

public final class PrimeGame implements Game {
  private static final String YES = "yes";
  private static final String NO = "no";
  private static final Random RANDOM = new Random();
  public static final int THREE = 3;
  private String answer;

  @Override
  public String getRules() {
    return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
  }

  @Override
  public String getQuestion() {
    var number = RANDOM.nextInt(Integer.MAX_VALUE);
    answer = isPrime(number) ? YES : NO;
    return String.valueOf(number);
  }

  private boolean isPrime(int number) {
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
    for (int i = THREE; i < sqrt; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
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
