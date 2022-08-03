package hexlet.code.games;

import static hexlet.code.GameEngine.CORRECT_QUESTIONS_FOR_WIN;
import static hexlet.code.GameEngine.startGame;
import static hexlet.code.Utils.getRandomNumber;

public class Progression {

    public static void startProgressionGame() {
        final int maxRandomNumberForQuestion = 100;
        final int maxRandomNumberForSum = 20;
        final int minRandomNumberForQuestion = 0;
        final int progressionNumbersCount = 15;

        String[][] questionsAndAnswers = prepareQuestionsAndAnswers(maxRandomNumberForQuestion,
                minRandomNumberForQuestion,
                progressionNumbersCount, maxRandomNumberForSum);
        String mainGameQuestionText = "What number is missing in the progression?";
        startGame(mainGameQuestionText, questionsAndAnswers);
    }

    public static String[][] prepareQuestionsAndAnswers(int maxRandomNumberForQuestion,
                                                        int minRandomNumberForQuestion, int progressionNumbersCount,
                                                        int maxRandomNumberForSum) {
        String[][] questionsAndAnswers = new String[CORRECT_QUESTIONS_FOR_WIN][2];
        for (int i = 0; i < CORRECT_QUESTIONS_FOR_WIN; i++) {
            int firstNumber = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            int addNumber = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForSum);
            int sum = firstNumber;
            questionsAndAnswers[i][0] = "";
            int hideNumberPosition = getRandomNumber(minRandomNumberForQuestion, progressionNumbersCount);
            for (int j = 0; j < progressionNumbersCount; j++) {
                sum += addNumber;
                if (hideNumberPosition == j) {
                    questionsAndAnswers[i][1] = String.valueOf(sum);
                    questionsAndAnswers[i][0] = questionsAndAnswers[i][0] + ".. ";
                } else {
                    questionsAndAnswers[i][0] = questionsAndAnswers[i][0] + sum + " ";
                }
            }
        }
        return questionsAndAnswers;
    }

}
