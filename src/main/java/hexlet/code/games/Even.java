package hexlet.code.games;

import static hexlet.code.Utils.getRandomNumber;
import static hexlet.code.games.GameActions.startGame;

public class Even {

    public static void startEvenGame(int needCorrectAnswers) {
        final int maxRandomNumberForQuestion = 100;
        final int minRandomNumberForQuestion = 0;
        String[] questions = prepareQuestions(needCorrectAnswers, maxRandomNumberForQuestion,
                minRandomNumberForQuestion);
        String[] answers = prepareAnswers(questions);
        String mainGameQuestionText = "Answer 'yes' if number even otherwise answer 'no'.";
        startGame(mainGameQuestionText, questions, answers);
    }

    private static String[] prepareAnswers(String[] questions) {
        String[] answers = new String[questions.length];
        for (int i = 0; i < questions.length; i++) {
            answers[i] = isNumberEven(Integer.parseInt(questions[i])) ? "yes" : "no";
        }
        return answers;
    }

    public static String[] prepareQuestions(int correctQuestionsForWin, int maxRandomNumberForQuestion,
                                            int minRandomNumberForQuestion) {
        String[] questions = new String[correctQuestionsForWin];
        for (int i = 0; i < correctQuestionsForWin; i++) {
            int number = getRandomNumber(minRandomNumberForQuestion, maxRandomNumberForQuestion);
            questions[i] = String.valueOf(number);
        }
        return questions;
    }

    public static boolean isNumberEven(int questionNumber) {
        int evenNumberForCheckQuestion = 2;
        return questionNumber % evenNumberForCheckQuestion == 0;
    }
}
