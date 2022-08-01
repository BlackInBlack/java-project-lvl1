package hexlet.code;

import java.util.Scanner;

import static hexlet.code.games.Calc.startCalcGame;
import static hexlet.code.games.Even.startEvenGame;
import static hexlet.code.games.GCD.startGCDGame;
import static hexlet.code.games.Greet.startGreetGame;
import static hexlet.code.games.Prime.startPrimeGame;
import static hexlet.code.games.Progression.startProgressionGame;

public class Main {

    public static void main(String[] args) {

        final int greetGameCode = 1;
        final int evenGameCode = 2;
        final int calcGameCode = 3;
        final int gcdGameCode = 4;
        final int progressionGameCode = 5;
        final int primeGameCode = 6;
        final int goodbyeCode = 0;
        final int gameNumber = getGamesNumbers();

        switch (gameNumber) {
            case greetGameCode -> startGreetGame();
            case evenGameCode -> startEvenGame();
            case calcGameCode -> startCalcGame();
            case gcdGameCode -> startGCDGame();
            case progressionGameCode -> startProgressionGame();
            case primeGameCode -> startPrimeGame();
            case goodbyeCode -> System.out.println("Goodbye!");
            default -> throw new IllegalStateException("Unexpected value: " + gameNumber);
        }
    }

    public static int getGamesNumbers() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:\s""");
        return sc.nextInt();
    }
}
