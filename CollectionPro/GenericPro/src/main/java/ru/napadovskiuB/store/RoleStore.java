package ru.napadovskiuB.store;

/**
 * Created by Программист on 04.07.2017.
 */
public class RoleStore<T extends Role> extends SimpleArrayStore {

    /**
     * Constructor class with size.
     *
     * @param size array size.
     */
    public RoleStore(int size) {
        super(size);
    }
}
