package ru.napadovskiyB;


/**
 * Package of CollectionPro finalTask.
 * Main class for order book.
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 09.08.2017
 */
public class CountChar implements Runnable {

    private String stringForCheck;

    private int count;

    public CountChar(String stringForCheck) {
        this.stringForCheck = stringForCheck;
    }

    @Override
    public void run() {
        char[] charArray = this.stringForCheck.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            this.count++;
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Поток был предварительно прерван число символов: "+this.count);
                return;
            }
        }

        System.out.println("Поток был завершен число символов: "+this.count);
    }
}
