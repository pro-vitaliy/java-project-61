package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class GCD {
    public static String[][] getQuestionsAnswersDict() {
        var maxRounds = 3;
        var questionAnswerPair = 2;
        return new String[maxRounds][questionAnswerPair];
    }

    public static String getStrDivider(int oneNum, int twoNum) {
        var divider = Math.min(oneNum, twoNum);

        while (divider > 1) {
            if (oneNum % divider == 0 && twoNum % divider == 0) {
                break;
            }
            divider--;
        }

        return String.valueOf(divider);
    }

    public static void startGcdGame() {
        String[][] quesAnswersDict = getQuestionsAnswersDict();
        Random random = new Random();

        for (var i = 0; i < quesAnswersDict.length; i++) {
            var maxFirstNum = 100;
            var maxSecNum = 100;
            var firstNum = random.nextInt(maxFirstNum);
            var secondNum = random.nextInt(maxSecNum);
            quesAnswersDict[i][0] = String.format("%d %d", firstNum, secondNum);
            quesAnswersDict[i][1] = getStrDivider(firstNum, secondNum);

        }

        var mission = "Find the greatest common divisor of given numbers.";
        Engine.checkUserAnswer(mission, quesAnswersDict);
    }
}
