package hexlet.code;

import java.util.Scanner;

public class GameEngine {
    final public static int correctQuestionsForWin = 3;

    public static void startGame(String mainGameQuestionText, String[][] questionsAndAnswers) {
        System.out.println("Welcome to the Brain Games!");
        Scanner sc = new Scanner(System.in);
        System.out.println("May I have your name? ");
        String name = sc.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println(mainGameQuestionText);
        for (int i = 0; i < correctQuestionsForWin; i++) {
            System.out.println("Question: " + questionsAndAnswers[0][i]);
            System.out.println("Your answer: ");
            String userAnswer = sc.nextLine();
            if (userAnswer.equals(questionsAndAnswers[1][i])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + questionsAndAnswers[1][i] + "'."
                        + "Let's try again, " + name + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }
}
