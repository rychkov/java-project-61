package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int REQUIRED_WIN_COUNT = 3;
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final int ANSWER_INDEX = 1;
    public static final int QUESTION_INDEX = 0;

    /**
     * Play game for player.
     * @param rules rules
     * @param items Q&A
     */
    public static void play(String rules, String[][] items) {
        int winCount = QUESTION_INDEX;
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        var name = SCANNER.next();
        System.out.printf("Hello, %s!%n", name);

        System.out.println(rules);
        for (var qa: items) {
            System.out.println("Question: " + qa[QUESTION_INDEX]);
            System.out.print("Your answer: ");
            var input = SCANNER.next();

            boolean isValid = qa[ANSWER_INDEX].equals(input);
            if (isValid) {
                winCount++;
                System.out.println("Correct!");
            } else {
                System.out.println(
                        "'%s' is wrong answer ;(. Correct answer was '%s' ".formatted(input, qa[ANSWER_INDEX])
                );
                System.out.printf("Let's try again, %s!%n", name);
                break;
            }
        }
        if (winCount == items.length) {
            System.out.printf("Congratulations, %s!%n", name);
        }
    }
}
