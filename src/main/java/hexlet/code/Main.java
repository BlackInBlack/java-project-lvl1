package hexlet.code;

import static hexlet.code.Cli.*;
import static hexlet.code.Games.*;

public class Main {
    public static void main(String[] args) {
        int gameNumber = getGameNumber();
        switch (gameNumber) {
            case 2 -> startEvenGame();
            case 3 -> startCalcGame();
            case 4 -> startGCDGame();
            case 5 -> startProgressionGame();
            case 6 -> startPrimeGame();
            case 0 -> System.out.println("Goodbye!");
        }
    }
}
