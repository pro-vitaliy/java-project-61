package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static String[] genProgressionAndHideElem() {
        final int minLength = 5;
        final int maxLength = 10;
        final int maxFirstElem = 30;
        final int maxStep = 10;

        int length = Utils.generateNum((maxLength - minLength) + 1) + minLength;
        int firstElem = Utils.generateNum(maxFirstElem);
        int step = Utils.generateNum(maxStep) + 1;
        int[] progression = new int[length];
        for (var i = 0; i < length; i++) {
            progression[i] = firstElem + i * step;
        }
        int hiddenElemIndex = Utils.generateNum(length);
        int hiddenElem = progression[hiddenElemIndex];

        StringBuilder strProgression = new StringBuilder();
        for (int elem : progression) {
            if (elem == hiddenElem) {
                strProgression.append(".. ");
            } else {
                strProgression.append(elem).append(" ");
            }
        }
        return new String[] {strProgression.toString(), String.valueOf(hiddenElem)};
    }

    public static void start() {
        String[][] quesAnswersDict = new String[Engine.MAX_ROUNDS][];

        for (var i = 0; i < quesAnswersDict.length; i++) {
            quesAnswersDict[i] = genProgressionAndHideElem();
        }
        var mission = "What number is missing in the progression?";
        Engine.runGame(mission, quesAnswersDict);
    }
}
