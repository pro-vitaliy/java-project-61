package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (var i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void start() {
        String[][] quesAnswersDict = new String[Engine.MAX_ROUNDS][];

        for (var i = 0; i < quesAnswersDict.length; i++) {
            final int maxNum = 100;
            int number = Utils.generateNum(maxNum);
            var answer = isPrime(number) ? "yes" : "no";
            quesAnswersDict[i] = new String[] {String.valueOf(number), answer};
        }

        var mission = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        Engine.runGame(mission, quesAnswersDict);
    }
}
