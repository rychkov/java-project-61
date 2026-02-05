package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public final class ProgressionGame {
  private static final int START_BOUND = 20;
  private static final int STEP_BOUND = 15;
  private static final int PROGRESSION_LENGTH = 10;
  private static final Random RANDOM = new Random();

  public static void play() {
    String[][] items = new String[Engine.REQUIRED_WIN_COUNT][2];
    for (int i = 0; i < Engine.REQUIRED_WIN_COUNT; i++) {
      items[i] = getQAtuple();
    }
    Engine.play(getRules(), items);
  }

  public static String getRules() {
    return "What number is missing in the progression?";
  }

  public static String[] getQAtuple() {
    var start = getSmallNumber(START_BOUND);
    var step = getSmallNumber(STEP_BOUND);
    var position = getSmallNumber(PROGRESSION_LENGTH);
    String answer = "";

    var progression = getProgression(start, step, PROGRESSION_LENGTH);
    answer = progression[position];
    progression[position] = "..";
    return new String[]{String.join(" ", progression), answer};
  }

  private static String[] getProgression(int start, int step, int len) {
    String[] result = new String[len];
    for (int i = 0; i < len; i++) {
      result[i] = String.valueOf(getProgressionValue(start, step, i));
    }
    return result;
  }

  private static int getProgressionValue(int start, int step, int i) {
      return start + step * i;
  }

  private static int getSmallNumber(int bound) {
      return RANDOM.nextInt(bound);
  }
}
