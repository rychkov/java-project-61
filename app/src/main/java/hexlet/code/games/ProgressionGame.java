package hexlet.code.games;

import java.util.Random;
import java.util.StringJoiner;

public final class ProgressionGame implements Game {
  private static final int START_BOUND = 20;
  private static final int STEP_BOUND = 15;
  private static final int PROGRESSION_LENGTH = 10;

  private String answer;
  private static final Random RANDOM = new Random();

  @Override
  public String getRules() {
    return "What number is missing in the progression?";
  }

  @Override
  public String getQuestion() {
    var start = getSmallNumber(START_BOUND);
    var step = getSmallNumber(STEP_BOUND);
    var position = getSmallNumber(PROGRESSION_LENGTH);

    StringJoiner joiner = new StringJoiner(" ");

    for (int i = 0; i < PROGRESSION_LENGTH; i++) {
      var value = getProgressionValue(start, step, i);
      if (i == position) {
        answer = String.valueOf(value);
        joiner.add("..");
      } else {
        joiner.add(String.valueOf(value));
      }
    }
    return joiner.toString();
  }

  private int getProgressionValue(int start, int step, int i) {
      return start + step * i;
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
