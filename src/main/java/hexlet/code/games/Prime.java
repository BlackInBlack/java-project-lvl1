package hexlet.code.games;

import static hexlet.code.Utils.getRandomNumber;
import static hexlet.code.games.GameActions.startGame;

public class Prime {

    public static void startPrimeGame(int needCorrectAnswers) {
        final int maxRandomNumberForQuestion = 100;
        final int minRandomNumberForQuestion = 0;
        String[] questions = prepareQuestions(needCorrectAnswers, maxRandomNumberForQuestion,
                minRandomNumberForQuestion);
        String[] answers = prepareAnswers(questions);
        String mainGameQuestionText = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        startGame(mainGameQuestionText, questions, answers);
    }

    private static String[] prepareAnswers(String[] questions) {
        String[] answers = new String[questions.length];
        for (int i = 0; i < questions.length; i++) {
            answers[i] = isNumberPrime(Integer.parseInt(questions[i])) ? "yes" : "no";
        }
        return answers;
    }

    public static String[] prepareQuestions(int correctQuestionsForWin, int maxRandomNumberForQuestion,
                                            int minRandomNumberForQuestion) {
        String[] questions = new String[correctQuestionsForWin];
        for (int i = 0; i < correctQuestionsForWin; i++) {
            int number = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            questions[i] = String.valueOf(number);
        }
        return questions;
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
