package ru.napadovskiuB;

import java.util.NoSuchElementException;

/**
 * Package of CollectionPro testTask.
 *
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 03.07.2017
 */
public class SimpleArray<T> {

    /**
     *Array for elements.
     */
    private Object[] objects;

    /**
     *cursor on current index of Array.
     */
    private int currentPosition;

    /**
     *Constructor class with size.
     * @param firstSize
     */
    public SimpleArray(int firstSize) {
        objects = new Object[firstSize];
    }

    /**
     *Method add value to array.
     * @param value value.
     */
    public void add(T value) {
        this.objects[this.currentPosition] = value;
        this.currentPosition++;
    }

    /**
     *Method return value by index.
     * @param index index from array.
     * @return value.
     */
    public T get(int index) {
        T result = null;
        if (index < this.objects.length) {
            result = (T) this.objects[index];
        }
        return result;
    }

    /**
     * Method update oldValue newValue.
     * @param oldValue oldValue.
     * @param newValue newValue.
     * @throws NoSuchElementException exception.
     */
    public void update(T oldValue, T newValue)  throws NoSuchElementException {
        boolean check = false;

        for(int i =0; i<objects.length; i++ ) {
            if (objects[i].equals(oldValue)) {
                objects[i] = newValue;
                check = true;
            }
        }
        if (!check) {
            throw new NoSuchElementException("No such element");
        }
    }

    /**
     *Method delete value from Array.
     * @param value value for delete.
     * @throws NoSuchElementException exception.
     */
    public void delete(T value)  throws  NoSuchElementException {
        for(int i =0; i<objects.length; i++ ) {
            if (objects[i].equals(value)) {
                objects[i] = null;
            }
        }
    }

}
