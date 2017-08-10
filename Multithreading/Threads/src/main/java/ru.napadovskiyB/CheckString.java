package ru.napadovskiyB;

/**
 * Package of CollectionPro finalTask.
 * Main class for order book.
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 09.08.2017
 */
public class CheckString implements Runnable {

    private String  stringForCheck;

    private int count;

    public CheckString(String stringForCheck) {
        this.stringForCheck = stringForCheck;
    }

    public int calcSpace() {
        int result = 0;
        return result;
    }

    public int calcWorlds() {
        int result = 0;
        return result;

    }

    @Override
    public void run() {
        System.out.println(count);
    }


}



