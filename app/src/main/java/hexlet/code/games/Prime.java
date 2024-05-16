package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Prime {
    public static String[][] getQuestionsAnswersDict() {
        final int maxRounds = 3;
        final int questionAnswerPair = 2;
        return new String[maxRounds][questionAnswerPair];
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (var i = 2; i < number; i++) {
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
            final int maxNum = 100;
            final int randomNum = random.nextInt(maxNum);
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
