package ru.napadovskiuB.EvenNumberIterator;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Package of chapter_003 testTask.
 *
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 15.06.2017
 */
public class EvenNumberIteratorTest {

    @Test
    public void TestArrayEvenNumber() {

        final int[] testArray = new int[] {1, 2, 4, 5};

        EvenNumberIterator evenNumberIterator  = new EvenNumberIterator(testArray);

        int number1 = (Integer) evenNumberIterator.next();
        int number2 = (Integer) evenNumberIterator.next();
        int number3 = (Integer) evenNumberIterator.next();
        int result = (Integer) evenNumberIterator.next();

        assertThat(result, is(5));


    }
}