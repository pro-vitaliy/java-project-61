package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Calc {
    public static void startCalcGame() {
        String[][] quesAnswersDict = new String[3][2];
        Random random = new Random();

        for (var i = 0; i < quesAnswersDict.length; i++) {
            var firstOperand = random.nextInt(20);
            var secondOperand = random.nextInt(20);
            var operatorIndex = random.nextInt(3);
            switch (operatorIndex) {
                case 0:
                    quesAnswersDict[i][0] = firstOperand + " + " + secondOperand;
                    quesAnswersDict[i][1] = String.valueOf(firstOperand + secondOperand);
                    break;
                case 1:
                    quesAnswersDict[i][0] = firstOperand + " - " + secondOperand;
                    quesAnswersDict[i][1] = String.valueOf(firstOperand - secondOperand);
                    break;
                case 2:
                    quesAnswersDict[i][0] = firstOperand + " * " + secondOperand;
                    quesAnswersDict[i][1] = String.valueOf(firstOperand * secondOperand);
                    break;
                default:
                    break;
            }

        }

        var mission = "What is the result of the expression?";
        Engine.checkUserAnswer(mission, quesAnswersDict);
    }
}
