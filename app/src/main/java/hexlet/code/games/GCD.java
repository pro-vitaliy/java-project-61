package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static int calculateGCD(int oneNum, int twoNum) {
        while (twoNum != 0) {
            int temp = twoNum;
            twoNum = oneNum % twoNum;
            oneNum = temp;
        }
        return oneNum;
    }

    public static void start() {
        String[][] quesAnswersDict = new String[Engine.MAX_ROUNDS][];

        for (var i = 0; i < quesAnswersDict.length; i++) {
            final int maxNum = 100;
            var firstNum = Utils.generateNum(maxNum);
            var secondNum = Utils.generateNum(maxNum);
            String question = String.format("%d %d", firstNum, secondNum);
            String answer = String.valueOf(calculateGCD(firstNum, secondNum));
            quesAnswersDict[i] = new String[] {question, answer};
        }

        var mission = "Find the greatest common divisor of given numbers.";
        Engine.runGame(mission, quesAnswersDict);
    }
}
