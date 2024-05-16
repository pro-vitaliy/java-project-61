package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Prime {
    public static String[][] getQuestionsAnswersDict() {
        var maxRounds = 3;
        var questionAnswerPair = 2;
        return new String[maxRounds][questionAnswerPair];
    }

    public static boolean isPrime(int number) {
        for (var i = (number - 1); i > 1; i--) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void startPrimeGame() {
        String[][] quesAnswersDict = getQuestionsAnswersDict();
        Random random = new Random();

        for (var i = 0; i < quesAnswersDict.length; i++) {
            var maxNum = 100;
            var randomNum = random.nextInt(maxNum);
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
