package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static String calculateGCD(int oneNum, int twoNum) {
        if (oneNum == 0 || twoNum == 0) {
            return String.valueOf(oneNum + twoNum);
        }
        var divider = Math.min(oneNum, twoNum);

        while (divider > 1) {
            if (oneNum % divider == 0 && twoNum % divider == 0) {
                break;
            }
            divider--;
        }

        return String.valueOf(divider);
    }

    public static void start() {
        String[][] quesAnswersDict = new String[Engine.MAX_ROUNDS][];

        for (var i = 0; i < quesAnswersDict.length; i++) {
            final int maxNum = 100;
            var firstNum = Utils.generateNum(maxNum);
            var secondNum = Utils.generateNum(maxNum);
            String question = String.format("%d %d", firstNum, secondNum);
            String answer = calculateGCD(firstNum, secondNum);
            quesAnswersDict[i] = new String[] {question, answer};
        }

        var mission = "Find the greatest common divisor of given numbers.";
        Engine.runGame(mission, quesAnswersDict);
    }
}
