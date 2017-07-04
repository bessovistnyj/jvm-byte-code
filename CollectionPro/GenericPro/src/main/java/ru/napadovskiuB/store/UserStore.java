package ru.napadovskiuB.store;

/**
 * Created by Программист on 04.07.2017.
 */
public class UserStore<T extends User> extends SimpleArrayStore {

    public UserStore(int size) {
        super(size);
    }
}
