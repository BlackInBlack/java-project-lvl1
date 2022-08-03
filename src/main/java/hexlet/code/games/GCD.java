package hexlet.code.games;

import static hexlet.code.GameEngine.CORRECT_QUESTIONS_FOR_WIN;
import static hexlet.code.GameEngine.startGame;
import static hexlet.code.Utils.getRandomNumber;

public class GCD {

    public static void startGCDGame() {
        final int maxRandomNumberForQuestion = 100;
        final int minRandomNumberForQuestion = 1;
        String[][] questionsAndAnswers = prepareQuestionsAndAnswers(maxRandomNumberForQuestion,
                minRandomNumberForQuestion);
        String mainGameQuestionText = "Find the greatest common divisor of given numbers.";
        startGame(mainGameQuestionText, questionsAndAnswers);
    }

    public static String[][] prepareQuestionsAndAnswers(int maxRandomNumberForQuestion,
                                                        int minRandomNumberForQuestion) {
        String[][] questionsAndAnswers = new String[CORRECT_QUESTIONS_FOR_WIN][2];
        for (int i = 0; i < CORRECT_QUESTIONS_FOR_WIN; i++) {
            int firstNumber = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            int secondNumber = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            questionsAndAnswers[i][0] = firstNumber + " " + secondNumber;
            questionsAndAnswers[i][1] = String.valueOf(findGCD(firstNumber, secondNumber));
        }
        return questionsAndAnswers;
    }

    public static int findGCD(int firstNumber, int secondNumber) {
        int gcd = Math.min(firstNumber, secondNumber);
        while (true) {
            if (firstNumber % gcd == 0 && secondNumber % gcd == 0) {
                return gcd;
            } else {
                gcd--;
            }
        }
    }
}
