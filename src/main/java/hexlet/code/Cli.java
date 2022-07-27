package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static String getUserName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("May I have your name? ");
        return sc.nextLine();
    }

    public static int getGameNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:\s""");
        return sc.nextInt();
    }

    public static String getUserAnswer() {
        System.out.println("Your answer: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
