package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Calc {
    private static final Random RANDOM = new Random();

    public static String getStrOperator() {
        var index = RANDOM.nextInt(3);
        return switch (index) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            default -> throw new IllegalStateException("Unexpected index value: " + index);
        };
    }

    public static void startCalcGame() {
        String[][] quesAnswersDict = new String[3][2];

        for (var i = 0; i < quesAnswersDict.length; i++) {
            var firstOperand = RANDOM.nextInt(20);
            var secondOperand = RANDOM.nextInt(20);
            int resOfExpression = 0;
            String strOperator = getStrOperator();

            switch (strOperator) {
                case "+":
                    resOfExpression = firstOperand + secondOperand;
                    break;
                case "-":
                    resOfExpression = firstOperand - secondOperand;
                    break;
                case "*":
                    resOfExpression = firstOperand * secondOperand;
                    break;
                default:
                    break;
            }
            quesAnswersDict[i][0] = String.format("%d %s %d", firstOperand, strOperator, secondOperand);
            quesAnswersDict[i][1] = String.valueOf(resOfExpression);
        }

        var mission = "What is the result of the expression?";
        Engine.checkUserAnswer(mission, quesAnswersDict);
    }
}
