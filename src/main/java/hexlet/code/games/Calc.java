package hexlet.code.games;

import static hexlet.code.Cli.getUserAnswer;
import static hexlet.code.Cli.getUserName;

public class Calc {
    public static void startCalcGame() {
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println("What is the result of the expression?");
        int correctAnswerCount = 0;
        while (correctAnswerCount < 3) {
            int firstNumber = (int) (Math.random() * 100);
            int secondNumber = (int) (Math.random() * 100);
            String[] operations = {"+", "*", "-"};
            String randomOperation = operations[(int) (Math.random() * 3)];
            String question = firstNumber + " " + randomOperation + " " + secondNumber;
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
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
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
            }
        }
        if (correctAnswerCount == 3) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
