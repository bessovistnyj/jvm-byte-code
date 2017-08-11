package ru.napadovskiyB;

import java.util.StringTokenizer;

/**
 * Package of CollectionPro finalTask.
 * Main class for order book.
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 09.08.2017
 */
public class CheckString implements Runnable {

    private String  stringForCheck;

    public CheckString(String stringForCheck) {
        this.stringForCheck = stringForCheck;
    }

    public int calcSpace() {
        int result = 0;
        String newString = this.stringForCheck.replaceAll(" ","");

        return result = this.stringForCheck.length()-newString.length();
    }

    public int calcWorlds() {
        int result = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(this.stringForCheck);
        while (stringTokenizer.hasMoreTokens()) {
            stringTokenizer.nextToken();
            result++;
        }
        return result;

    }

    @Override
    public void run() {
        System.out.println();
    }


}



