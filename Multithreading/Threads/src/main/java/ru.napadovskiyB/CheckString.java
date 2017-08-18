package ru.napadovskiyB;


import java.util.StringTokenizer;

/**
 * Package of CollectionPro finalTask.
 * Main class for order book.
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 09.08.2017
 */
public class CheckString  {

    /**
     * Method calculate space in string.
     * @param stringForCheck string.
     * @return result.
     */
    public Thread calcSpace(String  stringForCheck) {
        return new Thread() {
            @Override
            public void run() {
                String newString = stringForCheck.replaceAll(" ", "").trim();

                int result = stringForCheck.length() - newString.length();

                System.out.println(result);
            }
        };

    }


    /**
     *  Method calculate words in string.
     * @param stringForCheck string for check.
     * @return result
     */
    public Thread calcWorlds(String  stringForCheck) {
        return new Thread() {
            @Override
            public void run() {
                int count = 0;
                StringTokenizer stringTokenizer = new StringTokenizer(stringForCheck);

                while (stringTokenizer.hasMoreTokens()) {
                    stringTokenizer.nextElement();
                    count++;

                }
                System.out.println(count);
            }
        };
    }

    /**
     * Main method.
     * @param args array string.
     */
    public static void main(String[] args) {

        CheckString checkString = new CheckString();
        String  newString = "а баба галамага тест";

        Thread firstThread = checkString.calcSpace(newString);
        Thread secondThread = checkString.calcWorlds(newString);

        firstThread.start();
        secondThread.start();

    }

}



