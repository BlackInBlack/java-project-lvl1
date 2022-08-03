package hexlet.code.games;

import static hexlet.code.GameEngine.CORRECT_QUESTIONS_FOR_WIN;
import static hexlet.code.GameEngine.startGame;
import static hexlet.code.Utils.getRandomNumber;

public class Prime {

    public static void startPrimeGame() {
        final int maxRandomNumberForQuestion = 100;
        final int minRandomNumberForQuestion = 0;
        String[][] questionsAndAnswers = prepareQuestionsAndAnswers(maxRandomNumberForQuestion,
                minRandomNumberForQuestion);
        String mainGameQuestionText = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        startGame(mainGameQuestionText, questionsAndAnswers);
    }

    public static String[][] prepareQuestionsAndAnswers(int maxRandomNumberForQuestion,
                                                        int minRandomNumberForQuestion) {
        String[][] questionsAndAnswers = new String[CORRECT_QUESTIONS_FOR_WIN][2];
        for (int i = 0; i < CORRECT_QUESTIONS_FOR_WIN; i++) {
            int number = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            questionsAndAnswers[i][0] = String.valueOf(number);
            questionsAndAnswers[i][1] = isNumberPrime(number) ? "yes" : "no";
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
