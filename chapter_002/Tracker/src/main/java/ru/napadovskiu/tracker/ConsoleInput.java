package ru.napadovskiu.tracker;


import java.util.Scanner;

/**
 *
 */
public class ConsoleInput implements Input {

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
        System.out.println(question);
        return scanner.nextLine();
     }

}

