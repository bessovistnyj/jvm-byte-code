package ru.napadovskiuB;

import java.util.Collection;
import java.util.Iterator;


/**
 * Created by Napadovskiy on 25.05.2017.
 */
public class WorkWithCollection {

    /**
     * start time for test.
     */
    private long start;

    /**
     * end time for test.
     */
    private long end;


    /**
     * Method add strings to collection.
     * @param collection testing collection.
     * @param line String for add to collection.
     * @param amount amount strings for add to collection.
     * @return result time.
     */
    public long add(Collection<String> collection, String line, int amount) {

        long result;

        this.start = System.nanoTime();

        for (int i = 0; i < amount; i++) {
            collection.add(line);
        }

        this.end = System.nanoTime();

        result = this.end - this.start;

        return result;
    }


    /**
     * Method delete strings from collection.
     * @param collection for test.
     * @param amount amount strings for add to collection.
     * @return result time.
     */
    public long delete(Collection<String> collection, int amount) {

        long result;

        Iterator<String> iterator = collection.iterator();

        int count = 0;

        this.start = System.nanoTime();

        while (iterator.hasNext() && count < amount) {
            iterator.next();
            iterator.remove();
            count++;
        }

        this.end = System.nanoTime();

        result = this.end - this.start;

        return result;

    }


}
