package hexlet.code.games;

import static hexlet.code.GameEngine.correctQuestionsForWin;
import static hexlet.code.GameEngine.startGame;
import static hexlet.code.Utils.getRandomNumber;

public class Progression {

    public static void startProgressionGame() {
        final int maxRandomNumberForQuestion = 100;
        final int maxRandomNumberForSum = 20;
        final int minRandomNumberForQuestion = 0;
        final int progressionNumbersCount = 15;

        String[][] questionsAndAnswers = prepareQuestionsAndAnswers(maxRandomNumberForQuestion, minRandomNumberForQuestion,
                progressionNumbersCount, maxRandomNumberForSum);
        String mainGameQuestionText = "What number is missing in the progression?";
        startGame(mainGameQuestionText, questionsAndAnswers);
    }

    public static String[][] prepareQuestionsAndAnswers(int maxRandomNumberForQuestion,
                                            int minRandomNumberForQuestion, int progressionNumbersCount,
                                            int maxRandomNumberForSum) {
        String[][] questionsAndAnswers = new String[2][correctQuestionsForWin];
        for (int i = 0; i < correctQuestionsForWin; i++) {
            int firstNumber = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            int addNumber = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForSum);
            int sum = firstNumber;
            questionsAndAnswers[0][i] = "";
            int hideNumberPosition = getRandomNumber(minRandomNumberForQuestion, progressionNumbersCount);
            for (int j = 0; j < progressionNumbersCount; j++) {
                sum += addNumber;
                if(hideNumberPosition == j) {
                    questionsAndAnswers[1][i] = String.valueOf(sum);
                    questionsAndAnswers[0][i] = questionsAndAnswers[0][i] + ".. ";
                } else {
                    questionsAndAnswers[0][i] = questionsAndAnswers[0][i] + sum + " ";
                }
            }
        }
        return questionsAndAnswers;
    }

}
