package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Progression {
    private static Random random = new Random();

    public static int getLenOfProgression() {
        var maxLen = 10;
        var minLen = 5;
        return random.nextInt((maxLen - minLen) + 1) + minLen;
    }

    public static int[] getProgression() {
        var length = getLenOfProgression();
        int[] progression = new int[length];
        progression[0] = random.nextInt(30);
        var step = random.nextInt(10) + 1;  //Для исключения выпадения шага 0 прибавим единицу

        for (var i = 1; i < length; i++) {
            progression[i] = progression[i - 1] + step;
        }
        return progression;
    }

    public static String getQuestion(int[] sequence, int number) {
        String strSequence = "";

        for (int j : sequence) {
            if (j == number) {
                strSequence += ".. ";
            } else {
                strSequence += j + " ";
            }
        }
        return strSequence;
    }

    public static void startProgressionGame() {
        String[][] quesAnswersDict = new String[3][2];

        for (var i = 0; i < quesAnswersDict.length; i++) {
            var progression = getProgression();
            var secretNumIndex = random.nextInt(progression.length);
            var secretNum = progression[secretNumIndex];

            quesAnswersDict[i][0] = getQuestion(progression, secretNum);
            quesAnswersDict[i][1] = String.valueOf(secretNum);
        }

        var mission = "What number is missing in the progression?";
        Engine.checkUserAnswer(mission, quesAnswersDict);
    }
}
