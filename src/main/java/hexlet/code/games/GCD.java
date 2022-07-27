package hexlet.code.games;

import static hexlet.code.Cli.getUserAnswer;
import static hexlet.code.Cli.getUserName;

public class GCD {

    public static void startGCDGame() {
        int NEED_CORRECT_ANSWERS = 3;
        int MAX_RANDOM_NUMBER = 100;
        int MIN_RANDOM_NUMBER = 1;
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println("Find the greatest common divisor of given numbers.");
        int correctAnswerCount = 0;
        while (correctAnswerCount < NEED_CORRECT_ANSWERS) {
            int firstNumber = (int) (Math.random() * MAX_RANDOM_NUMBER) + MIN_RANDOM_NUMBER;
            int secondNumber = (int) (Math.random() * MAX_RANDOM_NUMBER) + MIN_RANDOM_NUMBER;
            String question = firstNumber + " " + secondNumber;
            System.out.println("Question: " + question);
            String answer = getUserAnswer();
            int correctAnswer = 0;
            int i = Math.min(firstNumber, secondNumber);
            while (true) {
                if (firstNumber % i == 0 && secondNumber % i == 0) {
                    correctAnswer = i;
                    break;
                } else {
                    i--;
                }
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
