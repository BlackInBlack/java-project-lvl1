package hexlet.code;

import static hexlet.code.Cli.getUserAnswer;
import static hexlet.code.Cli.getUserName;

public class Games {
    public static void startEvenGame() {
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        int correctAnswerCount = 0;
        while (correctAnswerCount < 3) {
            int number = getRandomNumber();
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

    public static void startCalcGame() {
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println("What is the result of the expression?");
        int correctAnswerCount = 0;
        while (correctAnswerCount < 3) {
            int firstNumber = getRandomNumber();
            int secondNumber = getRandomNumber();
            String[] operations = {"+", "*", "-"};
            String randomOperation = operations[(int) (Math.random() * 3)];
            String question = firstNumber + " " + randomOperation + " " + secondNumber;
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String answer = getUserAnswer();
            int correctAnswer = 0;
            switch (randomOperation) {
                case "+" -> correctAnswer = firstNumber + secondNumber;
                case "*" -> correctAnswer = firstNumber * secondNumber;
                case "-" -> correctAnswer = firstNumber - secondNumber;
            }
            if (answer.equals(String.valueOf(correctAnswer))) {
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

    public static void startGCDGame() {
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println("Find the greatest common divisor of given numbers.");
        int correctAnswerCount = 0;
        while (correctAnswerCount < 3) {
            int firstNumber = getRandomNumber() + 1;
            int secondNumber = getRandomNumber() + 1;
            String question = firstNumber + " " + secondNumber;
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String answer = getUserAnswer();
            int correctAnswer = 0;
            int i = Math.min(firstNumber, secondNumber);
            while (true) {
                if (firstNumber % i == 0 && secondNumber % i == 0) {
                    correctAnswer = i;
                    break;
                } else {
                    i--;
                }
            }
            if (answer.equals(String.valueOf(correctAnswer))) {
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

    public static void startProgressionGame() {
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println("What number is missing in the progression?");
        int correctAnswerCount = 0;
        while (correctAnswerCount < 3) {
            int firstNumber = getRandomNumber() + 1;

            int addNumber = (int) (Math.random() * 12 + 1);
            int hideNumberPosition = (int) (Math.random() * 15);
            int sum = firstNumber;
            int correctAnswer = 0;
            String question = "";
            for (int i = 0; i < 15; i++) {
                sum += addNumber;
                if (i == hideNumberPosition) {
                    correctAnswer = sum;
                    question = question + ".. ";
                } else {
                    question = question + sum + " ";
                }
            }
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String answer = getUserAnswer();
            if (answer.equals(String.valueOf(correctAnswer))) {
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

    public static void startPrimeGame() {
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        int correctAnswerCount = 0;
        while (correctAnswerCount < 3) {
            int questionNumber = getRandomNumber();
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
            System.out.print("Your answer: ");
            String answer = getUserAnswer();
            String correctAnswer = isQuestionNumberPrime ? "yes" : "no";
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

    public static int getRandomNumber() {
        return (int) (Math.random() * 100);
    }
}
