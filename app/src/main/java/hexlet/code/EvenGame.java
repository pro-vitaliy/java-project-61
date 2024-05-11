package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    public static boolean checkUserAnswer(int num, String answer) {
        var conditionFirstCheck = num % 2 == 0 && answer.equals("yes");
        var conditionSecondCheck = num % 2 != 0 && answer.equals("no");
        return conditionFirstCheck || conditionSecondCheck;
    }

    public static void startGame() {
        var userName = Cli.getNameAndGreetUser();

        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        var countCorrectAnswer = 0;

        while (countCorrectAnswer < 3) {
            int randomNum = random.nextInt(100);

            String correctAnswer;
            if (randomNum % 2 == 0) {
                correctAnswer = "yes";
            } else {
                correctAnswer = "no";
            }

            System.out.println("Question " + randomNum);
            System.out.println("Your answer:");
            String userAnswer = sc.nextLine();

            if (checkUserAnswer(randomNum, userAnswer)) {
                System.out.println("Correct!");
                countCorrectAnswer++;
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", userAnswer, correctAnswer);
                System.out.printf("Let's try again, %s!%n", userName);
                break;
            }
        }
        sc.close();

        if (countCorrectAnswer == 3) {
            System.out.printf("Congratulations, %s!%n", userName);
        }
    }
}
