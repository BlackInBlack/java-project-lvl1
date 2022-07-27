package hexlet.code.games;

import static hexlet.code.Cli.getUserAnswer;
import static hexlet.code.Cli.getUserName;

public class Progression {

    final static int NEED_CORRECT_ANSWERS = 3;
    final static int MAX_RANDOM_NUMBER = 100;
    final static int MAX_RANDOM_NUMBER_FOR_SUM = 100;
    final static int MIN_RANDOM_NUMBER = 1;
    final static int PROGRESSION_NUMBER_COUNT = 15;

    public static void startProgressionGame() {
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println("What number is missing in the progression?");
        int correctAnswerCount = 0;
        while (correctAnswerCount < NEED_CORRECT_ANSWERS) {
            int firstNumber = (int) (Math.random() * MAX_RANDOM_NUMBER) + MIN_RANDOM_NUMBER;

            int addNumber = (int) (Math.random() * MAX_RANDOM_NUMBER_FOR_SUM + MIN_RANDOM_NUMBER);
            int hideNumberPosition = (int) (Math.random() * PROGRESSION_NUMBER_COUNT);
            int sum = firstNumber;
            int correctAnswer = 0;
            String question = "";
            for (int i = 0; i < PROGRESSION_NUMBER_COUNT; i++) {
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
