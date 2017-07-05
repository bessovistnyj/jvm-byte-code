package ru.napadovskiuB.store;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Package of CollectionPro testTask.
 *
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 03.07.2017
 **/
public class UserStoreTest {

    /**
     *
     */
    @Test
    public void whenAddNewElementThenReturnValue() {
        final int arraySize = 3;
        User user1 = new User();
        user1.setId("123456");
        User user2 = new User();
        user2.setId("789654");
        UserStore<User> userStore = new UserStore<User>(arraySize);
        userStore.add(user1);
        userStore.add(user2);

        Base returnValue = userStore.get(0);
        assertThat(returnValue.getId(), is("123456"));

    }

    /**
     *
     */
    @Test
    public void whenUpdateElementThenReturnNewValue() {
        final int arraySize = 3;
        User user1 = new User();
        user1.setId("123456");
        User user2 = new User();
        user2.setId("789654");
        UserStore<User> userStore = new UserStore<User>(arraySize);
        userStore.add(user1);

        userStore.update(0, user2);

        Base returnValue = userStore.get(0);
        assertThat(returnValue.getId(), is("789654"));

    }


    /**
     *
     */
    @Test(expected = NullPointerException.class)
    public void whenDeleteElementThenReturnNewNull() {
        final int arraySize = 3;
        User user1 = new User();
        user1.setId("123456");
        User user2 = new User();
        user2.setId("789654");
        UserStore<User> userStore = new UserStore<User>(arraySize);
        userStore.add(user1);

        userStore.delete(user1);

        Base returnValue = userStore.get(0);

    }


}