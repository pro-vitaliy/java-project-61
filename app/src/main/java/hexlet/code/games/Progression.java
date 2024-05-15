package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Progression {
    private static final Random RANDOM = new Random();

    public static int getLenOfProgression() {
        var maxLen = 10;
        var minLen = 5;
        return RANDOM.nextInt((maxLen - minLen) + 1) + minLen;
    }

    public static int[] getProgression() {
        var length = getLenOfProgression();
        int[] progression = new int[length];
        progression[0] = RANDOM.nextInt(30);
        var step = RANDOM.nextInt(10) + 1;  //Для исключения выпадения шага 0 прибавим единицу

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
        String[][] quesAnswersDict = new String[3][2];

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
