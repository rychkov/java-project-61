package hexlet.code.games;

import java.util.Random;
import java.util.function.Predicate;

public final class EvenGame implements Game {
  private static final String YES = "yes";
  private static final String NO = "no";
  private static final Random RANDOM = new Random();
  private String answer;

  @Override
  public String getRules() {
    return "Answer 'yes' if the number is even, otherwise answer 'no'.";
  }

  private  final Predicate<Integer> isEven = i -> i % 2 != 0;

  @Override
  public String getQuestion() {
    int number = RANDOM.nextInt();
    answer = isEven.test(number) ? YES : NO;
    return String.valueOf(number);
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
