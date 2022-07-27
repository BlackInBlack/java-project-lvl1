package hexlet.code.games;

import static hexlet.code.Cli.getUserAnswer;
import static hexlet.code.Cli.getUserName;

public class Prime {

    public static void startPrimeGame() {
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        int correctAnswerCount = 0;
        while (correctAnswerCount < 3) {
            int questionNumber = (int) (Math.random() * 100);
            System.out.println("Question: " + questionNumber);
            boolean isQuestionNumberPrime = true;
            int half = questionNumber / 2;
            if (questionNumber == 0 || questionNumber == 1) {
                isQuestionNumberPrime = false;
            } else {
                for (int i = 2; i < half; i++) {
                    if (questionNumber % i == 0) {
                        isQuestionNumberPrime = false;
                        break;
                    }
                }
            }

            String answer = getUserAnswer();
            String correctAnswer = isQuestionNumberPrime ? "yes" : "no";
            if (answer.equals(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswerCount++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'." + "Let's try again, " + name + "!");
                return;
            }
        }
        if (correctAnswerCount == 3) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

}
