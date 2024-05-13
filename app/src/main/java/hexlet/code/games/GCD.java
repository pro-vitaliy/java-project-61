package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class GCD {
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
        String[][] quesAnswersDict = new String[3][2];
        Random random = new Random();

        for (var i = 0; i < quesAnswersDict.length; i++) {
            var firstNum = random.nextInt(100);
            var secondNum = random.nextInt(100);
            quesAnswersDict[i][0] = String.format("%d %d", firstNum, secondNum);
            quesAnswersDict[i][1] = getStrDivider(firstNum, secondNum);

        }

        var mission = "Find the greatest common divisor of given numbers.";
        Engine.checkUserAnswer(mission, quesAnswersDict);
    }
}
