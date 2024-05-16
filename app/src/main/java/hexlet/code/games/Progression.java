package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Progression {
    private static final Random RANDOM = new Random();

    public static String[][] getQuestionsAnswersDict() {
        final int maxRounds = 3;
        final int questionAnswerPair = 2;
        return new String[maxRounds][questionAnswerPair];
    }

    public static int[] getProgression() {
        final int maxLength = 10;
        final int minLength = 5;
        var length = RANDOM.nextInt((maxLength - minLength) + 1) + minLength;
        int[] progression = new int[length];

        final int maxFirstElem = 30;
        progression[0] = RANDOM.nextInt(maxFirstElem);
        final int maxStep = 10;
        var step = RANDOM.nextInt(maxStep) + 1;  //Для исключения выпадения шага 0 прибавим 1

        for (var i = 1; i < length; i++) {
            progression[i] = progression[i - 1] + step;
        }

        return progression;
    }

    public static String getStrProgression(int[] sequence, int number) {
        StringBuilder strProgression = new StringBuilder();

        for (int elem : sequence) {
            if (elem == number) {
                strProgression.append(".. ");
            } else {
                strProgression.append(elem).append(" ");
            }
        }
        return strProgression.toString();
    }

    public static void startProgressionGame() {
        String[][] quesAnswersDict = getQuestionsAnswersDict();

        for (var i = 0; i < quesAnswersDict.length; i++) {
            var progression = getProgression();
            var secretNumIndex = RANDOM.nextInt(progression.length);
            var secretNum = progression[secretNumIndex];

            quesAnswersDict[i][0] = getStrProgression(progression, secretNum);
            quesAnswersDict[i][1] = String.valueOf(secretNum);
        }

        var mission = "What number is missing in the progression?";
        Engine.checkUserAnswer(mission, quesAnswersDict);
    }
}
