package ru.napadovskiuB;

import java.util.Collection;
import java.util.Iterator;


/**
 * Created by Программист on 25.05.2017.
 */
public class WorkWithCollection {

    /**
     *
     */
    private long start;

    /**
     *
     */
    private long end;


    /**
     *
     * @param collection
     * @param line
     * @param amount
     * @return
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
     *
     * @param collection
     * @param amount
     * @return
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
