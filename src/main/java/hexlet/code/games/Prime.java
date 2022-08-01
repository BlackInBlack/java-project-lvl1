package hexlet.code.games;

import static hexlet.code.GameEngine.correctQuestionsForWin;
import static hexlet.code.GameEngine.startGame;
import static hexlet.code.Utils.getRandomNumber;

public class Prime {

    public static void startPrimeGame() {
        final int maxRandomNumberForQuestion = 100;
        final int minRandomNumberForQuestion = 0;
        String[][] questionsAndAnswers = prepareQuestionsAndAnswers(maxRandomNumberForQuestion, minRandomNumberForQuestion);
        String mainGameQuestionText = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        startGame(mainGameQuestionText, questionsAndAnswers);
    }

    public static String[][] prepareQuestionsAndAnswers(int maxRandomNumberForQuestion, int minRandomNumberForQuestion) {
        String[][] questionsAndAnswers = new String[2][correctQuestionsForWin];
        for (int i = 0; i < correctQuestionsForWin; i++) {
            int number = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            questionsAndAnswers[0][i] = String.valueOf(number);
            questionsAndAnswers[1][i] = isNumberPrime(number) ? "yes" : "no";
        }
        return questionsAndAnswers;
    }

    public static boolean isNumberPrime(int questionNumber) {
        int half = questionNumber / 2;
        if (questionNumber == 0 || questionNumber == 1) {
            return false;
        } else {
            for (int i = 2; i < half; i++) {
                if (questionNumber % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
