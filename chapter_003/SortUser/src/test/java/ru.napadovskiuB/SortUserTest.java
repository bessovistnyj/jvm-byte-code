package ru.napadovskiuB;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Napadovskiy Bohdan on 08.06.2017.
 */
public class SortUserTest {

    /**
     *
     */
    @Test
    public void sortTest() {

        SortUser sortUser = new SortUser();
        final int firstAge = 25;
        final int secondAge = 20;
        User firstUser = new User(firstAge, "Иван");
        User secondUser = new User(secondAge, "Петр");

        ArrayList<User> list = new ArrayList<User>();

        list.add(firstUser);
        list.add(secondUser);

        Set<User> treeSet = sortUser.sort(list);

        assertThat(treeSet.toArray()[0], is(secondUser));

    }
}