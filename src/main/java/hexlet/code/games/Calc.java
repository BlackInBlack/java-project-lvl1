package hexlet.code.games;

import static hexlet.code.GameEngine.CORRECT_QUESTIONS_FOR_WIN;
import static hexlet.code.GameEngine.startGame;
import static hexlet.code.Utils.getRandomNumber;

public class Calc {

    public static void startCalcGame() {
        final int maxRandomNumberForQuestion = 100;
        final int minRandomNumberForQuestion = 0;

        String[][] questionsAndAnswers = prepareQuestionsAndAnswers(maxRandomNumberForQuestion,
                minRandomNumberForQuestion);
        String mainGameQuestionText = "What is the result of the expression?";
        startGame(mainGameQuestionText, questionsAndAnswers);
    }

    public static String[][] prepareQuestionsAndAnswers(int maxRandomNumberForQuestion,
                                                        int minRandomNumberForQuestion) {
        final int operationsCountInQuestion = 3;
        String[][] questionsAndAnswers = new String[2][CORRECT_QUESTIONS_FOR_WIN];
        for (int i = 0; i < CORRECT_QUESTIONS_FOR_WIN; i++) {
            String[] operations = {"+", "*", "-"};
            String randomOperation = operations[(int) (Math.random() * operationsCountInQuestion)];
            int firstNumber = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            int secondNumber = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            questionsAndAnswers[0][i] = firstNumber + " " + randomOperation + " " + secondNumber;
            switch (randomOperation) {
                case "+":
                    questionsAndAnswers[1][i] = String.valueOf(firstNumber + secondNumber);
                    break;
                case "*":
                    questionsAndAnswers[1][i] = String.valueOf(firstNumber * secondNumber);
                    break;
                case "-":
                    questionsAndAnswers[1][i] = String.valueOf(firstNumber - secondNumber);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + randomOperation);
            }
        }
        return questionsAndAnswers;
    }
}
