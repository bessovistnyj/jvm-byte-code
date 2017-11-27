package ru.napadovskiy.bomberman;

import java.util.Scanner;

/**
 *
 */
public class ConsoleInput {

    /**
     *
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     *
     * @param question
     * @return
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     *
     * @param question
     * @return
     */
    public String askUser(String question) {
        String text = "";
        while (text.equals("w") & text.equals("s") & text.equals("a") & text.equals("d")) {
            text = ask(question);
        }
        return text;
    }
}
