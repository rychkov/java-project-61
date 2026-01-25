package hexlet.code;

import hexlet.code.games.EvenGame;
import java.util.List;

/**
 * App main class.
 */
public final class App {

  private static final List<MenuItem> MENU_ITEMS = List.of(
      new MenuItem(1, "Greet"),
      new MenuItem(2, "Even"),
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
        case 1: Cli.showGreeting();
                name = Cli.readName();
                break;
        case 2: new EvenGame().play(name);
                break;
        default: break;
      }
    } while (number != 0);
  }
}
