package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.print("""
            Please enter the game number and press Enter.
            1 - Greet
            2 - Even
            3 - Calc
            4 - GCD
            5 - Progression
            6 - Prime
            0 - Exit
            Your choice:\s""");
        Scanner sc = new Scanner(System.in);
        String userChoice = sc.nextLine();
        startGame(userChoice);
    }

    public static void startGame(String choice) {
        switch (choice) {
            case "1" -> Cli.getNameAndGreetUser();
            case "2" -> EvenGame.startEvenGame();
            case "3" -> Calc.startCalcGame();
            case "4" -> GCD.startGcdGame();
            case "5" -> Progression.startProgressionGame();
            case "6" -> Prime.startPrimeGame();
            default -> {
                // Exit
            }
        }
    }
}
