package ru.napadovskiyB;

/**
 * Package of CollectionPro finalTask.
 * Main class for order book.
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 09.08.2017
 */
public class Time implements Runnable {

    private long checkTime;

    public Time(int checkTime) {
        this.checkTime = checkTime;
    }


    @Override
    public void run() {
        long start = System.currentTimeMillis();

//         if ((System.currentTimeMillis()-start) > checkTime) {
//             Thread.currentThread().interrupted();
//
//         }
    }

}
