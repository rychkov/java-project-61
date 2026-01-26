package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

import java.util.List;

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

  private static final List<MenuItem> MENU_ITEMS = List.of(
      new MenuItem(GREETING_KEY, "Greet"),
      new MenuItem(EVEN_GAME_KEY, "Even"),
      new MenuItem(CALC_GAME_KEY, "Calc"),
      new MenuItem(GCD_GAME_KEY, "GCD"),
      new MenuItem(PROGRESSION_GAME_KEY, "Progression"),
      new MenuItem(PRIME_GAME_KEY, "Prime"),
      new MenuItem(0, "Exit")
  );

  private App() {
  }

  /**
   * Main method.
   * @param args args :)
   */
  public static void main(final String[] args) {
    int number = 0;
    String name = "";
    do {
      System.out.println("Please enter the game number and press Enter.");
      MENU_ITEMS.forEach(item -> System.out.println(item.key() + " - " + item.name()));

      number = Cli.readInt();
      switch (number) {
        case GREETING_KEY: Cli.showGreeting();
                name = Cli.readName();
                break;
        case EVEN_GAME_KEY: Engine.play(name, new EvenGame());
                break;
        case CALC_GAME_KEY: Engine.play(name, new CalcGame());
                break;
        case GCD_GAME_KEY: Engine.play(name, new GcdGame());
                break;
        case PROGRESSION_GAME_KEY: Engine.play(name, new ProgressionGame());
                break;
        case PRIME_GAME_KEY: Engine.play(name, new PrimeGame());
                break;
        default: break;
      }
    } while (number != 0);
    Cli.SCANNER.close();
    System.exit(0);
  }
}
