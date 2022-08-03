package hexlet.code;

import java.util.Scanner;

public class GameEngine {
    public static final int CORRECT_QUESTIONS_FOR_WIN = 3;

    public static void startGame(String mainGameQuestionText, String[][] questionsAndAnswers) {
        System.out.println("Welcome to the Brain Games!");
        Scanner sc = new Scanner(System.in);
        System.out.println("May I have your name? ");
        String name = sc.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println(mainGameQuestionText);
        for (int i = 0; i < CORRECT_QUESTIONS_FOR_WIN; i++) {
            System.out.println("Question: " + questionsAndAnswers[i][0]);
            System.out.println("Your answer: ");
            String userAnswer = sc.nextLine();
            if (userAnswer.equals(questionsAndAnswers[1][i])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + questionsAndAnswers[i][1] + "'." + "Let's try again, " + name + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }
}
