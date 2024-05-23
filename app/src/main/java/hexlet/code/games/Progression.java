package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    private static int[] generateProgression(int length, int firstNum, int step) {
        int[] progression = new int[length];
        for (var i = 0; i < length; i++) {
            progression[i] = firstNum + i * step;
        }
        return progression;
    }

    private static String formatProgression(int[] progression, int number) {
        StringBuilder formattedProgression = new StringBuilder();
        for (int elem : progression) {
            if (elem == number) {
                formattedProgression.append(".. ");
            } else {
                formattedProgression.append(elem).append(" ");
            }
        }
        return String.valueOf(formattedProgression);
    }

    public static void start() {
        String[][] quesAnswersDict = Utils.buildQuestionsAnswersArray();

        for (var i = 0; i < quesAnswersDict.length; i++) {
            final int minLength = 5;
            final int maxLength = 10;
            final int maxFirstElem = 30;
            final int maxStep = 10;

            int length = Utils.generateNum((maxLength - minLength) + 1) + minLength;
            int firstElem = Utils.generateNum(maxFirstElem);
            int step = Utils.generateNum(maxStep) + 1;
            int[] progression = generateProgression(length, firstElem, step);

            int hiddenElemIndex = Utils.generateNum(length);
            int hiddenElem = progression[hiddenElemIndex];

            String question = formatProgression(progression, hiddenElem);
            String answer = String.valueOf(hiddenElem);
            quesAnswersDict[i] = new String[] {question, answer};
        }

        var mission = "What number is missing in the progression?";
        Engine.runGame(mission, quesAnswersDict);
    }
}
