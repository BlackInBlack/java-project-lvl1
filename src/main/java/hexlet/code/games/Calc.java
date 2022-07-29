package hexlet.code.games;

import static hexlet.code.Utils.getRandomNumber;
import static hexlet.code.games.GameActions.startGame;

public class Calc {

    public static void startCalcGame(int needCorrectAnswers) {
        final int maxRandomNumberForQuestion = 100;
        final int minRandomNumberForQuestion = 0;

        String[] questions = prepareQuestions(needCorrectAnswers, maxRandomNumberForQuestion,
                minRandomNumberForQuestion);
        String[] answers = prepareAnswers(questions);
        String mainGameQuestionText = "What is the result of the expression?";
        startGame(mainGameQuestionText, questions, answers);
    }

    private static String[] prepareAnswers(String[] questions) {
        String[] answers = new String[questions.length];
        for (int i = 0; i < questions.length; i++) {
            String[] questionMembers = questions[i].split(" ");
            int firstNumber = Integer.parseInt(questionMembers[0]);
            String operation = questionMembers[1];
            int secondNumber = Integer.parseInt(questionMembers[2]);
            switch (operation) {
                case "+":
                    answers[i] = String.valueOf(firstNumber + secondNumber);
                    break;
                case "*":
                    answers[i] = String.valueOf(firstNumber * secondNumber);
                    break;
                case "-":
                    answers[i] = String.valueOf(firstNumber - secondNumber);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operation);
            }
        }
        return answers;
    }

    public static String[] prepareQuestions(int correctQuestionsForWin, int maxRandomNumberForQuestion,
                                            int minRandomNumberForQuestion) {
        final int operationsCountInQuestion = 3;
        String[] questions = new String[correctQuestionsForWin];
        for (int i = 0; i < correctQuestionsForWin; i++) {
            String[] operations = {"+", "*", "-"};
            String randomOperation = operations[(int) (Math.random() * operationsCountInQuestion)];
            int firstNumber = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            int secondNumber = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            questions[i] = firstNumber + " " + randomOperation + " " + secondNumber;
        }
        return questions;
    }
}
