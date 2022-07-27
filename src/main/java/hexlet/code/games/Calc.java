package hexlet.code.games;

import static hexlet.code.Cli.getUserAnswer;
import static hexlet.code.Cli.getUserName;

public class Calc {

    public static void startCalcGame() {
        int NEED_CORRECT_ANSWERS = 3;
        int MAX_RANDOM_NUMBER = 100;
        int OPERATIONS_COUNT = 3;
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println("What is the result of the expression?");
        int correctAnswerCount = 0;
        while (correctAnswerCount < NEED_CORRECT_ANSWERS) {
            int firstNumber = (int) (Math.random() * MAX_RANDOM_NUMBER);
            int secondNumber = (int) (Math.random() * MAX_RANDOM_NUMBER);
            String[] operations = {"+", "*", "-"};
            String randomOperation = operations[(int) (Math.random() * OPERATIONS_COUNT)];
            String question = firstNumber + " " + randomOperation + " " + secondNumber;
            System.out.println("Question: " + question);
            String answer = getUserAnswer();
            int correctAnswer = 0;
            switch (randomOperation) {
                case "+" -> correctAnswer = firstNumber + secondNumber;
                case "*" -> correctAnswer = firstNumber * secondNumber;
                case "-" -> correctAnswer = firstNumber - secondNumber;
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
        if (correctAnswerCount == NEED_CORRECT_ANSWERS) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
