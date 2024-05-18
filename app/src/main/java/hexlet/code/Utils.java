package hexlet.code;

import java.util.Random;

public class Utils {
    public static int generateNum(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    public static int[] generateProgression(int minLength, int maxLength, int lowerBound, int step) {
        var length = generateNum((maxLength - minLength) + 1) + minLength;
        int[] progression = new int[length];
        progression[0] = generateNum(lowerBound);
        for (var i = 1; i < length; i++) {
            progression[i] = progression[i - 1] + step;
        }
        return progression;
    }
}
