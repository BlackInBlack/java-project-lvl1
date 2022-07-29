package hexlet.code.games;

import static hexlet.code.user.UserActions.getUserName;

public class Greet {
    public static void startGreetGame() {
        System.out.println("Welcome to the Brain Games!");
        String name = getUserName();
        System.out.println("Hello, " + name + "!");
    }
}
