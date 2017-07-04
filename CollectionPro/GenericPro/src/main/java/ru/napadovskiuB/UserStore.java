package ru.napadovskiuB;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created by Программист on 04.07.2017.
 */
public class UserStore<T> implements Store{


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
    public UserStore(int size) {
        objects = new Base[size];
    }


    /**
     *
     * @param value
     */
    @Override
    public void add(Base value) {
        this.objects[this.currentPosition++] = value;
    }

    @Override
    public void update(Base oldValue, Base newValue) throws NoSuchElementException {
        boolean check = false;

        for (int i = 0; i < this.objects.length; i++) {
            if (this.objects[i] != null) {
                if (this.objects[i].equals(oldValue)) {
                    this.objects[i] = newValue;
                    check = true;
                    break;
                }
            }
        }
        if (!check) {
            throw new NoSuchElementException("No such element");
        }

    }

    @Override
    public Base[] delete( Base base ) {
        for (int i = 0; i < this.objects.length; i++) {
            if (this.objects[i].equals(base)) {
                objects[i] = null;
            }
        }

        Base[] result = Arrays.copyOf(this.objects, this.objects.length-1);

        return result;

    }

}
