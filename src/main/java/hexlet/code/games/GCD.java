package hexlet.code.games;

import static hexlet.code.Cli.getUserAnswer;
import static hexlet.code.Cli.getUserName;

public class GCD {

    public static void startGCDGame(int needCorrectAnswers) {
        int maxRandomNumberForQuestion = 100;
        int minRandomNumberForQuestion = 1;
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println("Find the greatest common divisor of given numbers.");
        int correctAnswerCount = 0;
        while (correctAnswerCount < needCorrectAnswers) {
            int firstNumber = (int) (Math.random() * maxRandomNumberForQuestion) + minRandomNumberForQuestion;
            int secondNumber = (int) (Math.random() * maxRandomNumberForQuestion) + minRandomNumberForQuestion;
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
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'."
                        + "Let's try again, " + name + "!");
                return;
            }
        }
        if (correctAnswerCount == needCorrectAnswers) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
