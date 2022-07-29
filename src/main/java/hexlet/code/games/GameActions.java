package hexlet.code.games;

import static hexlet.code.user.UserActions.getUserAnswer;
import static hexlet.code.user.UserActions.getUserName;

public class GameActions {
    public static void startGame(String mainGameQuestionText, String[] questions, String[] answers) {
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println(mainGameQuestionText);
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question: " + questions[i]);
            String userAnswer = getUserAnswer();
            if (userAnswer.equals(answers[i])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + answers[i] + "'."
                        + "Let's try again, " + name + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }
}
