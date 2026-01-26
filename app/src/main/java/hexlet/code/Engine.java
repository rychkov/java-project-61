package hexlet.code;

import hexlet.code.games.Game;

public class Engine {
    private static final int REQUIRED_WIN_COUNT = 3;

    /**
     * Play game for player.
     * @param name player name
     * @param game game
     */
    static void play(String name, Game game) {
        int winCount = 0;
        System.out.println(game.getRules());
        do {
            System.out.println("Question: " + game.getQuestion());
            System.out.print("Your answer: ");
            var input = Cli.readString();

            boolean isValid = game.isValidInput(input);
            if (isValid) {
                winCount++;
                System.out.println("Correct!");
            } else {
                System.out.println(
                        "'%s' is wrong answer ;(. Correct answer was '%s' ".formatted(input, game.getCorrectAnswer())
                );
                System.out.printf("Let's try again, %s!%n", name);
                break;
            }
        } while (winCount < REQUIRED_WIN_COUNT);
        if (winCount == REQUIRED_WIN_COUNT) {
            System.out.printf("Congratulations, %s!%n", name);
        }
    }
}
