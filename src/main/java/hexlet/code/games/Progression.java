package hexlet.code.games;

import static hexlet.code.Cli.getUserAnswer;
import static hexlet.code.Cli.getUserName;

public class Progression {

    public static void startProgressionGame(int needCorrectAnswers) {
        int maxRandomNumber = 100;
        int maxRandomNumberForSum = 100;
        int minRandomNumber = 1;
        int progressionNumberCount = 15;
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println("What number is missing in the progression?");
        int correctAnswerCount = 0;
        while (correctAnswerCount < needCorrectAnswers) {
            int firstNumber = (int) (Math.random() * maxRandomNumber) + minRandomNumber;

            int addNumber = (int) (Math.random() * maxRandomNumberForSum + minRandomNumber);
            int hideNumberPosition = (int) (Math.random() * progressionNumberCount);
            int sum = firstNumber;
            int correctAnswer = 0;
            String question = "";
            for (int i = 0; i < progressionNumberCount; i++) {
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
        if (correctAnswerCount == needCorrectAnswers) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
