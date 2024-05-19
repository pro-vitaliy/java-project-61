package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final Scanner SC = new Scanner(System.in);
    public static final int MAX_ROUNDS = 3;

    public static String getNameAndGreetUser() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = SC.nextLine();
        System.out.printf("Hello, %s!%n", userName);
        return userName;
    }

    public static void runGame(String task, String[][] quesAndAnswers) {
        var userName = getNameAndGreetUser();
        System.out.println(task);

        for (var dict : quesAndAnswers) {
            var question = dict[0];
            var correctAnswer = dict[1];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            var userAnswer = SC.nextLine();
            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", userAnswer, correctAnswer);
                System.out.printf("Let's try again, %s!%n", userName);
                return;
            }
        }
        System.out.printf("Congratulations, %s!%n", userName);
        SC.close();
    }
}
