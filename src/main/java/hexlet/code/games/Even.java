package hexlet.code.games;

import static hexlet.code.GameEngine.CORRECT_QUESTIONS_FOR_WIN;
import static hexlet.code.GameEngine.startGame;
import static hexlet.code.Utils.getRandomNumber;

public class Even {

    public static void startEvenGame() {
        final int maxRandomNumberForQuestion = 100;
        final int minRandomNumberForQuestion = 0;
        String[][] questionsAndAnswers = prepareQuestionsAndAnswers(maxRandomNumberForQuestion,
                minRandomNumberForQuestion);
        String mainGameQuestionText = "Answer 'yes' if number even otherwise answer 'no'.";
        startGame(mainGameQuestionText, questionsAndAnswers);
    }

    public static String[][] prepareQuestionsAndAnswers(int maxRandomNumberForQuestion,
                                                        int minRandomNumberForQuestion) {
        String[][] questionsAndAnswers = new String[CORRECT_QUESTIONS_FOR_WIN][2];
        for (int i = 0; i < CORRECT_QUESTIONS_FOR_WIN; i++) {
            int number = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            questionsAndAnswers[i][0] = String.valueOf(number);
            questionsAndAnswers[i][1] = isNumberEven(number) ? "yes" : "no";
        }
        return questionsAndAnswers;
    }

    public static boolean isNumberEven(int questionNumber) {
        int evenNumberForCheckQuestion = 2;
        return questionNumber % evenNumberForCheckQuestion == 0;
    }
}
