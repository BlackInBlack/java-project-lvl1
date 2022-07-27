package hexlet.code.games;

import static hexlet.code.Cli.getUserAnswer;
import static hexlet.code.Cli.getUserName;

public class Even {

    final static int NEED_CORRECT_ANSWERS = 3;
    final static int MAX_RANDOM_NUMBER = 100;
    final static int EVEN_NUMBER_CHECK = 2;
    public static void startEvenGame() {
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        int correctAnswerCount = 0;
        while (correctAnswerCount < NEED_CORRECT_ANSWERS) {
            int number = (int) (Math.random() * MAX_RANDOM_NUMBER);
            boolean isNumberEven = number % EVEN_NUMBER_CHECK == 0;
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
        if (correctAnswerCount == NEED_CORRECT_ANSWERS) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
