package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class EvenGame {
    public static void startEvenGame() {
        String[][] quesAnswersDict = new String[3][2];
        Random random = new Random();

        for (var i = 0; i < quesAnswersDict.length; i++) {
            var randomNum = random.nextInt(100);
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
