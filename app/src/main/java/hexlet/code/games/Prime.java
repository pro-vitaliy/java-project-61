package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Prime {
    public static boolean isPrime(int number) {
        for (var i = (number - 1); i > 1; i--) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void startPrimeGame() {
        String[][] quesAnswersDict = new String[3][2];
        Random random = new Random();

        for (var i = 0; i < quesAnswersDict.length; i++) {
            var randomNum = random.nextInt(100);
            quesAnswersDict[i][0] = "" + randomNum;
            if (isPrime(randomNum)) {
                quesAnswersDict[i][1] = "yes";
            } else {
                quesAnswersDict[i][1] = "no";
            }
        }

        var mission = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        Engine.checkUserAnswer(mission, quesAnswersDict);
    }
}
