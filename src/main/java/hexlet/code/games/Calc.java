package hexlet.code.games;

import static hexlet.code.Cli.getUserAnswer;
import static hexlet.code.Cli.getUserName;

public class Calc {

    public static void startCalcGame(int needCorrectAnswers) {
        int maxRandomNumber = 100;
        int operationsCount = 3;
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println("What is the result of the expression?");
        int correctAnswerCount = 0;
        while (correctAnswerCount < needCorrectAnswers) {
            int firstNumber = (int) (Math.random() * maxRandomNumber);
            int secondNumber = (int) (Math.random() * maxRandomNumber);
            String[] operations = {"+", "*", "-"};
            String randomOperation = operations[(int) (Math.random() * operationsCount)];
            String question = firstNumber + " " + randomOperation + " " + secondNumber;
            System.out.println("Question: " + question);
            String answer = getUserAnswer();
            int correctAnswer = 0;
            switch (randomOperation) {
                case "+" -> correctAnswer = firstNumber + secondNumber;
                case "*" -> correctAnswer = firstNumber * secondNumber;
                case "-" -> correctAnswer = firstNumber - secondNumber;
                default -> throw new IllegalStateException("Unexpected value: " + randomOperation);
            }
            if (answer.equals(String.valueOf(correctAnswer))) {
                System.out.println("Correct!");
                correctAnswerCount++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'." +
                        "Let's try again, " + name + "!");
                return;
            }
        }
        if (correctAnswerCount == needCorrectAnswers) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
