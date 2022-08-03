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
        String[][] questionsAndAnswers = new String[CORRECT_QUESTIONS_FOR_WIN][2];
        for (int i = 0; i < CORRECT_QUESTIONS_FOR_WIN; i++) {
            String[] operations = {"+", "*", "-"};
            String randomOperation = operations[(int) (Math.random() * operationsCountInQuestion)];
            int firstNumber = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            int secondNumber = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            questionsAndAnswers[i][0] = firstNumber + " " + randomOperation + " " + secondNumber;
            questionsAndAnswers[i][1] = String.valueOf(getResultForCalc(randomOperation, firstNumber, secondNumber));
        }
        return questionsAndAnswers;
    }

    public static int getResultForCalc(String operation, int firstNumber, int secondNumber) {
        switch (operation) {
            case "+":
                return firstNumber + secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "-":
                return firstNumber - secondNumber;
            default:
                throw new IllegalStateException("Unexpected value: " + operation);
        }
    }
}
