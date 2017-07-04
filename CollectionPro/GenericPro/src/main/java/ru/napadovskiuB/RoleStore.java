package ru.napadovskiuB;

import java.util.Arrays;

/**
 * Created by Программист on 04.07.2017.
 */
public class RoleStore<T> implements Store {

    /**
     *Array for elements.
     */
    private Base[] objects;

    /**
     *cursor on current index of Array.
     */
    private int currentPosition;

    /**
     *Constructor class with size.
     * @param size array size.
     */
    public RoleStore(int size) {
        objects = new Base[size];
    }


    @Override
    public void add(Base value) {

    }

    @Override
    public void update(Base oldValue, Base newValue) {

    }

    @Override
    public Base[] delete(Base base) {
        for (int i = 0; i < this.objects.length; i++) {
            if (this.objects[i].equals(base)) {
                objects[i] = null;
            }
        }

        Base[] result = Arrays.copyOf(this.objects, this.objects.length-1);

        return result;

    }
}
