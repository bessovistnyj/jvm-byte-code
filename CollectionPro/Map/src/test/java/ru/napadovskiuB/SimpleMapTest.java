package ru.napadovskiuB;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 *
 */
public class SimpleMapTest {

    /**
     *
     */
    @Test
    public void whenInsertThenReturnValue() {
        SimpleMap<Integer, String> myMap = new SimpleMap<>();

        myMap.insert(5, "Пятый");
        myMap.insert(4, "Четвертый");
        myMap.insert(2, "Второй");

        String checkValue = myMap.get(4);

        assertThat(checkValue, is("Четвертый"));

    }


    /**
     *
     */
    @Test (expected = NullPointerException.class)
    public void whenDeleteItemThenReturnNull() {
        SimpleMap<Integer, String> myMap = new SimpleMap<>();

        myMap.insert(5, "Пятый");
        myMap.insert(4, "Четвертый");
        myMap.insert(2, "Второй");


        myMap.delete(4);
        String checkValue = myMap.get(4);

    }

}