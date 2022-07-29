package hexlet.code.games;

import static hexlet.code.Utils.getRandomNumber;
import static hexlet.code.games.GameActions.startGame;

public class GCD {

    public static void startGCDGame(int needCorrectAnswers) {
        final int maxRandomNumberForQuestion = 100;
        final int minRandomNumberForQuestion = 1;
        String[] questions = prepareQuestions(needCorrectAnswers, maxRandomNumberForQuestion,
                minRandomNumberForQuestion);
        String[] answers = prepareAnswers(questions);
        String mainGameQuestionText = "Find the greatest common divisor of given numbers.";
        startGame(mainGameQuestionText, questions, answers);
    }

    private static String[] prepareAnswers(String[] questions) {
        String[] answers = new String[questions.length];
        for (int i = 0; i < questions.length; i++) {
            String[] numberFromQuestion = questions[i].split(" ");
            int firstNumber = Integer.parseInt(numberFromQuestion[0]);
            int secondNumber = Integer.parseInt(numberFromQuestion[1]);
            answers[i] = String.valueOf(findGCD(firstNumber, secondNumber));
        }
        return answers;
    }

    public static String[] prepareQuestions(int correctQuestionsForWin, int maxRandomNumberForQuestion,
                                            int minRandomNumberForQuestion) {
        String[] questions = new String[correctQuestionsForWin];
        for (int i = 0; i < correctQuestionsForWin; i++) {
            int firstNumber = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            int secondNumber = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            questions[i] = firstNumber + " " + secondNumber;
        }
        return questions;
    }

    public static int findGCD(int firstNumber, int secondNumber) {
        int gcd = Math.min(firstNumber, secondNumber);
        while (true) {
            if (firstNumber % gcd == 0 && secondNumber % gcd == 0) {
                return gcd;
            } else {
                gcd--;
            }
        }
    }
}
