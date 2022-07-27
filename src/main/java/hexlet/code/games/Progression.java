package hexlet.code.games;

import static hexlet.code.Cli.getUserAnswer;
import static hexlet.code.Cli.getUserName;

public class Progression {
    public static void startProgressionGame() {
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println("What number is missing in the progression?");
        int correctAnswerCount = 0;
        while (correctAnswerCount < 3) {
            int firstNumber = (int) (Math.random() * 100) + 1;

            int addNumber = (int) (Math.random() * 12 + 1);
            int hideNumberPosition = (int) (Math.random() * 15);
            int sum = firstNumber;
            int correctAnswer = 0;
            String question = "";
            for (int i = 0; i < 15; i++) {
                sum += addNumber;
                if (i == hideNumberPosition) {
                    correctAnswer = sum;
                    question = question + ".. ";
                } else {
                    question = question + sum + " ";
                }
            }
            System.out.println("Question: " + question);
            String answer = getUserAnswer();
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
