package ru.napadovskiuB.store;

import org.junit.Test;

/**
 * Created by Владелец on 04.07.2017.
 */
public class UserStoreTest {

    @Test
    public void whenAddNewEllementThenReturn() {
        User user1 = new User();
        User user2 = new User();
        UserStore<User> userStore = new UserStore<User>(3);
        userStore.add(user1);
        userStore.add(user2);
        int a=2;
    }

}