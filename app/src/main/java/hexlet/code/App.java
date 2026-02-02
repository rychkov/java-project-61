package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

/**
 * App main class.
 */
public final class App {

  public static final int GREETING_KEY = 1;
  public static final int EVEN_GAME_KEY = 2;
  public static final int CALC_GAME_KEY = 3;
  public static final int GCD_GAME_KEY = 4;
  public static final int PROGRESSION_GAME_KEY = 5;
  public static final int PRIME_GAME_KEY = 6;

  private App() {
  }

  /**
   * Main method.
   * @param args args :)
   */
  public static void main(final String[] args) {
    int number = 0;
    System.out.println("Please enter the game number and press Enter.");

    System.out.printf("%d - %s%n", GREETING_KEY, "Greet");
    System.out.printf("%d - %s%n", EVEN_GAME_KEY, "Even");
    System.out.printf("%d - %s%n", CALC_GAME_KEY, "Calc");
    System.out.printf("%d - %s%n", GCD_GAME_KEY, "GCD");
    System.out.printf("%d - %s%n", PROGRESSION_GAME_KEY, "Progression");
    System.out.printf("%d - %s%n", PRIME_GAME_KEY, "Prime");
    System.out.printf("%d - %s%n", 0, "Exit");

    number = Cli.readInt();
    switch (number) {
      case GREETING_KEY:
        Cli.showGreeting();
        break;
      case EVEN_GAME_KEY:
        EvenGame.play();
        break;
      case CALC_GAME_KEY:
        CalcGame.play();
        break;
      case GCD_GAME_KEY:
        GcdGame.play();
        break;
      case PROGRESSION_GAME_KEY:
        ProgressionGame.play();
        break;
      case PRIME_GAME_KEY:
        PrimeGame.play();
        break;
      default:
        break;
    }
    Cli.SCANNER.close();
  }
}
