package hexlet.code.games;

/**
 * Game interface.
 */
public interface Game {

  /**
   * Get rules.
   * @return rules
   */
  String getRules();

  /**
   * Get question.
   * @return question
   */
  String getQuestion();

  /**
   * Check if input is valid.
   * @param value value to check
   * @return {@code true} if value is valid, {@code false} otherwise
   */
  boolean isValidInput(String value);

  /**
   * Get correct answer.
   * @return answer
   */
  String getCorrectAnswer();
}
