package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static int evaluateExpression(int firstOperand, int secondOperand, String operator) {
        return switch (operator) {
            case "+" -> firstOperand + secondOperand;
            case "-" -> firstOperand - secondOperand;
            case "*" -> firstOperand * secondOperand;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }

    public static void start() {
        String[][] quesAnswersDict = new String[Engine.MAX_ROUNDS][];

        for (var i = 0; i < quesAnswersDict.length; i++) {
            final int maxOperand = 20;
            int firstOperand = Utils.generateNum(maxOperand);
            int secondOperand = Utils.generateNum(maxOperand);

            String[] operators = new String[] {"+", "-", "*"};
            var operatorIndex = Utils.generateNum(operators.length);
            String operator = operators[operatorIndex];
            int resultOfExpression = evaluateExpression(firstOperand, secondOperand, operator);

            String question = String.format("%d %s %d", firstOperand, operator, secondOperand);
            String answer = String.valueOf(resultOfExpression);
            quesAnswersDict[i] = new String[] {question, answer};
        }
        var mission = "What is the result of the expression?";
        Engine.runGame(mission, quesAnswersDict);
    }
}
