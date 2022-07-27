package hexlet.code.games;

import static hexlet.code.Cli.getUserAnswer;
import static hexlet.code.Cli.getUserName;

public class Even {

    public static void startEvenGame(int needCorrectAnswers) {
        int maxRandomNumber = 100;
        int evenNumberCheck = 2;
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        int correctAnswerCount = 0;
        while (correctAnswerCount < needCorrectAnswers) {
            int number = (int) (Math.random() * maxRandomNumber);
            boolean isNumberEven = number % evenNumberCheck == 0;
            System.out.println("Question: " + number);
            String answer = getUserAnswer();
            String correctAnswer = isNumberEven ? "yes" : "no";
            if (answer.equals(correctAnswer)) {
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
