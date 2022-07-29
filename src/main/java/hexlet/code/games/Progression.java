package hexlet.code.games;

import static hexlet.code.Utils.getRandomNumber;
import static hexlet.code.games.GameActions.startGame;

public class Progression {

    public static void startProgressionGame(int needCorrectAnswers) {
        final int maxRandomNumberForQuestion = 100;
        final int maxRandomNumberForSum = 20;
        final int minRandomNumberForQuestion = 0;
        final int progressionNumbersCount = 15;

        String[] questions = prepareQuestions(needCorrectAnswers, maxRandomNumberForQuestion,
                minRandomNumberForQuestion, progressionNumbersCount, maxRandomNumberForSum);
        String[] answers = new String[questions.length];
        for (int i = 0; i < questions.length; i++) {
            String[] questionsProgressionNumbers = questions[i].split(" ");
            int hideNumberPosition = getRandomNumber(minRandomNumberForQuestion, progressionNumbersCount);
            answers[i] = questionsProgressionNumbers[hideNumberPosition];
            questions[i] = questions[i].replace(answers[i], "..");
        }
        String mainGameQuestionText = "What number is missing in the progression?";
        startGame(mainGameQuestionText, questions, answers);
    }

    public static String[] prepareQuestions(int correctQuestionsForWin, int maxRandomNumberForQuestion,
                                            int minRandomNumberForQuestion, int progressionNumbersCount,
                                            int maxRandomNumberForSum) {
        String[] questions = new String[correctQuestionsForWin];
        for (int i = 0; i < correctQuestionsForWin; i++) {
            int firstNumber = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            int addNumber = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForSum);
            int sum = firstNumber;
            questions[i] = "";
            for (int j = 0; j < progressionNumbersCount; j++) {
                sum += addNumber;
                questions[i] = questions[i] + sum + " ";
            }
        }
        return questions;
    }

}
