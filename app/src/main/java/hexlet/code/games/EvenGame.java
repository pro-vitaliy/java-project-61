package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class EvenGame {
    public static String[][] getQuestionsAnswersDict() {
        var maxRounds = 3;
        var questionAnswerPair = 2;
        return new String[maxRounds][questionAnswerPair];
    }

    public static void startEvenGame() {
        String[][] quesAnswersDict = getQuestionsAnswersDict();
        Random random = new Random();

        for (var i = 0; i < quesAnswersDict.length; i++) {
            var maxNum = 100;
            var randomNum = random.nextInt(maxNum);
            quesAnswersDict[i][0] = "" + randomNum;
            if (randomNum % 2 == 0) {
                quesAnswersDict[i][1] = "yes";
            } else {
                quesAnswersDict[i][1] = "no";
            }
        }

        var mission = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.checkUserAnswer(mission, quesAnswersDict);
    }
}
