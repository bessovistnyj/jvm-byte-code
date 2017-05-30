package ru.napadovskiuB;

import org.junit.Test;


import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by Napadovskiy on 30.05.2017.
 */
public class WorkWithCollectionTest {

    /**
     * Method check adds string to collection.
     */
    @Test
    public void whenAddStringThenCollectionNotEmpty() {
        String randomString;

        final int length = 10;

        final int amount = 1;

        ArrayList<String> arrayList = new ArrayList<String>();

        CreateRandomString createRandomString = new CreateRandomString();

        WorkWithCollection workWithCollection = new WorkWithCollection();

        randomString = createRandomString.createRandomString(length);

        workWithCollection.add(arrayList, randomString, amount);


        assertThat(arrayList.get(0), is(randomString));

    }

    /**
     *  Method check delete string from collection.
     */

    @Test
    public void whenDeleteStringThenCollectionEmpty()  {
        String randomString;

        final int length = 10;

        final int amount = 1;

        boolean result = true;

        ArrayList<String> arrayList = new ArrayList<String>();

        CreateRandomString createRandomString = new CreateRandomString();

        WorkWithCollection workWithCollection = new WorkWithCollection();

        randomString = createRandomString.createRandomString(length);

        workWithCollection.add(arrayList, randomString, amount);
        workWithCollection.delete(arrayList, amount);

        assertThat(arrayList.isEmpty(), is(result));

    }

}