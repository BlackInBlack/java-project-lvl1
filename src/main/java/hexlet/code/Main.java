package hexlet.code;

import static hexlet.code.Cli.*;
import static hexlet.code.games.Calc.startCalcGame;
import static hexlet.code.games.Even.startEvenGame;
import static hexlet.code.games.GCD.startGCDGame;
import static hexlet.code.games.Prime.startPrimeGame;
import static hexlet.code.games.Progression.startProgressionGame;

public class Main {
    final public static int FIRST_GAME_CODE = 1;
    final public static int EVEN_GAME_CODE = 2;
    final public static int CALC_GAME_CODE = 3;
    final public static int GCD_GAME_CODE = 4;
    final public static int PROGRESSION_GAME_CODE = 5;
    final public static int PRIME_GAME_CODE = 6;
    final public static int GOODBYE_CODE = 0;
    public static void main(String[] args) {
        int gameNumber = getGameNumber();
        switch (gameNumber) {
            case FIRST_GAME_CODE -> startEvenGame();
            case EVEN_GAME_CODE -> startEvenGame();
            case CALC_GAME_CODE -> startCalcGame();
            case GCD_GAME_CODE -> startGCDGame();
            case PROGRESSION_GAME_CODE -> startProgressionGame();
            case PRIME_GAME_CODE -> startPrimeGame();
            case GOODBYE_CODE -> System.out.println("Goodbye!");
        }
    }
}
