package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        System.out.println("Your choice: ");

        Scanner sc = new Scanner(System.in);
        String userChoice = sc.nextLine();

        switch (userChoice) {
            case "1":
                Cli.getNameAndGreetUser();
                break;
            case "2":
                EvenGame.startGame();
                break;
            case "0":
                break;
            default:
                break;
        }
    }
}
