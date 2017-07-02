package ru.napadovskiuB.IteratorOfIterators;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Package of chapter_003 testTask.
 *
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 01.07.2017
 */
public class IteratorOfIteratorsTest {


    @Test
    public void testIteratorOfItertor() {
        List<Integer> firstList = Arrays.asList(4, 2, 0, 4, 6, 4, 9);
        List<Integer> secondList = Arrays.asList(0, 9, 8, 7, 5);
        List<Integer> thirdList = Arrays.asList(1, 3, 5, 6, 7, 0, 9, 8, 4);


        Iterator<Integer> firsIterator = firstList.iterator();
        Iterator<Integer> secondIterator = secondList.iterator();
        Iterator<Integer> thirdIterator = thirdList.iterator();
        List<Iterator<Integer>>  ListIt = Arrays.asList(firsIterator,secondIterator, thirdIterator);
        Iterator<Iterator<Integer>> it =  ListIt.iterator();

        IteratorOfIterators iteratorOfIterators = new IteratorOfIterators(it);

        Iterator<Integer> result = iteratorOfIterators.convert(it);
        Integer firstResult = result.next();
        Integer secondResult = result.next();
        Integer thirdResult = result.next();
        Integer  a2 = result.next();
        int a =1;

    }

}