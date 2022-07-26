package hexlet.code.games;

import static hexlet.code.Cli.getUserAnswer;
import static hexlet.code.Cli.getUserName;

public class Even {
    public static void startEvenGame() {
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        int correctAnswerCount = 0;
        while (correctAnswerCount < 3) {
            int number = (int) (Math.random() * 100);
            boolean isNumberEven = number % 2 == 0;
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String answer = getUserAnswer();
            String correctAnswer = isNumberEven ? "yes" : "no";
            if (answer.equals(correctAnswer)) {
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
