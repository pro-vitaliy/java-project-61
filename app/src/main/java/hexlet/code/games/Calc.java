package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Calc {
    private static final Random RANDOM = new Random();

    public static String[][] getQuestionsAnswersDict() {
        var maxRounds = 3;
        var questionAnswerPair = 2;
        return new String[maxRounds][questionAnswerPair];
    }

    public static String getStrOperator() {
        var maxIndex = 3;
        var index = RANDOM.nextInt(maxIndex);
        return switch (index) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            default -> throw new IllegalStateException("Unexpected index value: " + index);
        };
    }

    public static void startCalcGame() {
        String[][] quesAnswersDict = getQuestionsAnswersDict();
        for (var i = 0; i < quesAnswersDict.length; i++) {
            var maxOperand = 20;
            var firstOperand = RANDOM.nextInt(maxOperand);
            var secondOperand = RANDOM.nextInt(maxOperand);
            int resOfExpression;
            String strOperator = getStrOperator();

            resOfExpression = switch (strOperator) {
                case "+" -> firstOperand + secondOperand;
                case "-" -> firstOperand - secondOperand;
                case "*" -> firstOperand * secondOperand;
                default -> throw new IllegalStateException("Unexpected value: " + strOperator);
            };

            quesAnswersDict[i][0] = String.format("%d %s %d", firstOperand, strOperator, secondOperand);
            quesAnswersDict[i][1] = String.valueOf(resOfExpression);
        }
        var mission = "What is the result of the expression?";
        Engine.checkUserAnswer(mission, quesAnswersDict);
    }
}
