package hexlet.code;

import static hexlet.code.Cli.*;
import static hexlet.code.games.Calc.startCalcGame;
import static hexlet.code.games.Even.startEvenGame;
import static hexlet.code.games.GCD.startGCDGame;
import static hexlet.code.games.Greet.startGreetGame;
import static hexlet.code.games.Prime.startPrimeGame;
import static hexlet.code.games.Progression.startProgressionGame;

public class Main {

    public static void main(String[] args) {
        int needCorrectAnswers = 3;

        final int greetGameCode = 1;
        final int evenGameCode = 2;
        final int calcGameCode = 3;
        final int gcdGameCode = 4;
        final int progressionGameCode = 5;
        final int primeGameCode = 6;
        final int goodbyeCode = 0;
        final int gameNumber = getGameNumber();

        switch (gameNumber) {
            case greetGameCode -> startGreetGame();
            case evenGameCode -> startEvenGame(needCorrectAnswers);
            case calcGameCode -> startCalcGame(needCorrectAnswers);
            case gcdGameCode -> startGCDGame(needCorrectAnswers);
            case progressionGameCode -> startProgressionGame(needCorrectAnswers);
            case primeGameCode -> startPrimeGame(needCorrectAnswers);
            case goodbyeCode -> System.out.println("Goodbye!");
            default -> throw new IllegalStateException("Unexpected value: " + gameNumber);
        }
    }
}
