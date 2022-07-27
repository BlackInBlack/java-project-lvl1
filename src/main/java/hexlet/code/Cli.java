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
        System.out.println("Please enter the game number and press Enter.\n" +
                "1 - Greet\n" +
                "2 - Even\n" +
                "3 - Calc\n" +
                "4 - GCD\n" +
                "5 - Progression\n" +
                "6 - Prime\n" +
                "0 - Exit\n" +
                "Your choice: ");
        return sc.nextInt();
    }

    public static String getUserAnswer() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
