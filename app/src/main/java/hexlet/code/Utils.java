package hexlet.code;

import java.util.Random;

public class Utils {
    public static int generateNum(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    public static String[][] buildQuestionsAnswersArray() {
        return new String[Engine.MAX_ROUNDS][];
    }
}
