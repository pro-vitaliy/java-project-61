package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void start() {
        String[][] quesAnswersDict = new String[Engine.MAX_ROUNDS][];

        for (var i = 0; i < quesAnswersDict.length; i++) {
            final int maxNum = 200;
            var number = Utils.generateNum(maxNum);
            var answer = isEven(number) ? "yes" : "no";
            quesAnswersDict[i] = new String[] {String.valueOf(number), answer};
        }
        var mission = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.runGame(mission, quesAnswersDict);
    }
}
