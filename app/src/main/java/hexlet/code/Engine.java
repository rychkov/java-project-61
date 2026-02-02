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
        showGreeting();
        var name = readName();

        System.out.println(rules);
        for (var qa: items) {
            System.out.println("Question: " + qa[QUESTION_INDEX]);
            System.out.print("Your answer: ");
            var input = readString();

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

    /**
     * Show greetings.
     */
    public static void showGreeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
    }

    /**
     * Read user name.
     * @return user name
     */
    public static String readName() {
        var name = readString();
        System.out.printf("Hello, %s!%n", name);
        return name;
    }

    /**
     * Read string from console.
     * @return string
     */
    public static String readString() {
        return SCANNER.next();
    }

    /**
     * Read int from console.
     * @return value
     */
    public static int readInt() {
        do {
            if (SCANNER.hasNextInt()) {
                var value = SCANNER.nextInt();
                //System.out.println("> Input -> " + value);
                return value;
            } else {
                //Skip non int input
                System.out.println("> Unexpected input -> " + SCANNER.next());
            }
        } while (true);
    }
}
