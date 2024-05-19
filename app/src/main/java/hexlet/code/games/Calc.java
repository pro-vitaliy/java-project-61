package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static String[] genExpressionAndResult() {
        final int maxOperand = 20;
        int firstOperand = Utils.generateNum(maxOperand);
        int secondOperand = Utils.generateNum(maxOperand);

        String[] operators = new String[] {"+", "-", "*"};
        var operatorIndex = Utils.generateNum(operators.length);
        String operator = operators[operatorIndex];

        int resultOfExpression = switch (operator) {
            case "+" -> firstOperand + secondOperand;
            case "-" -> firstOperand - secondOperand;
            case "*" -> firstOperand * secondOperand;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
        String expression = String.format("%d %s %d", firstOperand, operator, secondOperand);
        String result = String.valueOf(resultOfExpression);
        return new String[] {expression, result};
    }

    public static void start() {
        String[][] quesAnswersDict = new String[Engine.MAX_ROUNDS][];

        for (var i = 0; i < quesAnswersDict.length; i++) {
            quesAnswersDict[i] = genExpressionAndResult();
        }
        var mission = "What is the result of the expression?";
        Engine.runGame(mission, quesAnswersDict);
    }
}
