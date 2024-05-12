package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final Scanner sc = new Scanner(System.in);

    public static String getNameAndGreetUser() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String userName = sc.nextLine();
        System.out.printf("Hello, %s!%n", userName);
        return userName;
    }

    public static void checkUserAnswer(String task, String[][] quesAndAnswers) {
        var userName = getNameAndGreetUser();
        System.out.println(task);
        var counter = 0;

        while (counter < 3) {
            var question = quesAndAnswers[counter][0];
            var correctAnswer = quesAndAnswers[counter][1];
            System.out.println("Question: " + question);
            System.out.println("Your answer:");
            var userAnswer = sc.nextLine();
            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                counter++;
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", userAnswer, correctAnswer);
                System.out.printf("Let's try again, %s!%n", userName);
                break;
            }
        }

        if (counter == 3) {
            System.out.printf("Congratulations, %s!%n", userName);
        }
        sc.close();
    }
}
