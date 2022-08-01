package hexlet.code.games;

import static hexlet.code.GameEngine.correctQuestionsForWin;
import static hexlet.code.GameEngine.startGame;
import static hexlet.code.Utils.getRandomNumber;

public class Even {

    public static void startEvenGame() {
        final int maxRandomNumberForQuestion = 100;
        final int minRandomNumberForQuestion = 0;
        String[][] questionsAndAnswers = prepareQuestionsAndAnswers(maxRandomNumberForQuestion, minRandomNumberForQuestion);
        String mainGameQuestionText = "Answer 'yes' if number even otherwise answer 'no'.";
        startGame(mainGameQuestionText, questionsAndAnswers);
    }

    public static String[][] prepareQuestionsAndAnswers(int maxRandomNumberForQuestion, int minRandomNumberForQuestion) {
        String[][] questionsAndAnswers = new String[2][correctQuestionsForWin];
        for (int i = 0; i < correctQuestionsForWin; i++) {
            int number = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            questionsAndAnswers[0][i] = String.valueOf(number);
            questionsAndAnswers[1][i] = isNumberEven(number) ? "yes" : "no";
        }
        return questionsAndAnswers;
    }

    public static boolean isNumberEven(int questionNumber) {
        int evenNumberForCheckQuestion = 2;
        return questionNumber % evenNumberForCheckQuestion == 0;
    }
}
