package ru.napadovskiuB;

import java.util.Collection;
import java.util.Iterator;


/**
 * Created by napadovskiuB on 25.05.2017.
 */
public class WorkWithCollection {

    /**
     * time to start test.
     */
    private long start;

    /**
     * end time test.
     */
    private long end;


    /**
     * Method add to collection strings.
     * @param collection type of collection.
     * @param line string add to collection.
     * @param amount amount string
     * @return result time the adding string to collection.
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
     * @param collection type of collection.
     * @param amount amount of strings.
     * @return result time the adding string to collection.
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