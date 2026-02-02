package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.StringJoiner;

public final class ProgressionGame {
  private static final int START_BOUND = 20;
  private static final int STEP_BOUND = 15;
  private static final int PROGRESSION_LENGTH = 10;
  private static final Random RANDOM = new Random();

  public static void play() {
    QAtuple[] items = new QAtuple[Engine.REQUIRED_WIN_COUNT];
    for (int i = 0; i < Engine.REQUIRED_WIN_COUNT; i++) {
      items[i] = getQAtuple();
    }
    Engine.play(getRules(), items);
  }

  public static String getRules() {
    return "What number is missing in the progression?";
  }

  public static QAtuple getQAtuple() {
    var start = getSmallNumber(START_BOUND);
    var step = getSmallNumber(STEP_BOUND);
    var position = getSmallNumber(PROGRESSION_LENGTH);
    String answer = "";

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
    return new QAtuple(joiner.toString(), answer);
  }

  private static int getProgressionValue(int start, int step, int i) {
      return start + step * i;
  }

  private static int getSmallNumber(int bound) {
      return RANDOM.nextInt(bound);
  }
}
