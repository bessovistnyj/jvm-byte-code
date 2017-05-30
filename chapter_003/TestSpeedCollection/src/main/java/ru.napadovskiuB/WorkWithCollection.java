package ru.napadovskiuB;

import java.util.Collection;
import java.util.Iterator;


/**
<<<<<<< HEAD
 * Created by Napadovskiy on 25.05.2017.
=======
 * Created by napadovskiuB on 25.05.2017.
>>>>>>> 48a903de654ac10c8f32e95fc512153901c311fb
 */
public class WorkWithCollection {

    /**
<<<<<<< HEAD
     * start time for test.
=======
     * time to start test.
>>>>>>> 48a903de654ac10c8f32e95fc512153901c311fb
     */
    private long start;

    /**
<<<<<<< HEAD
     * end time for test.
=======
     * end time test.
>>>>>>> 48a903de654ac10c8f32e95fc512153901c311fb
     */
    private long end;


    /**
<<<<<<< HEAD
     * Method add strings to collection.
     * @param collection testing collection.
     * @param line String for add to collection.
     * @param amount amount strings for add to collection.
     * @return result time.
=======
     * Method add to collection strings.
     * @param collection type of collection.
     * @param line string add to collection.
     * @param amount amount string
     * @return result time the adding string to collection.
>>>>>>> 48a903de654ac10c8f32e95fc512153901c311fb
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
<<<<<<< HEAD
     * @param collection for test.
     * @param amount amount strings for add to collection.
     * @return result time.
=======
     * @param collection type of collection.
     * @param amount amount of strings.
     * @return result time the adding string to collection.
>>>>>>> 48a903de654ac10c8f32e95fc512153901c311fb
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
<<<<<<< HEAD


}
=======
}
>>>>>>> 48a903de654ac10c8f32e95fc512153901c311fb
