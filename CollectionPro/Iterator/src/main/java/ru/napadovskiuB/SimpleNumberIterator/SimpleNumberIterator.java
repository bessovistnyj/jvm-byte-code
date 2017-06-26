package ru.napadovskiuB.SimpleNumberIterator;

import java.util.Iterator;

/**
 * Even number iterator.
 *
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 22.06.2017
 */
public class SimpleNumberIterator implements Iterator {

    private int[] array;

    private int cursor = 0;

    public SimpleNumberIterator (int[] array) {
        this.array = array;

    }

    private int checkSimpleNumber() {
        int position = this.cursor;
        for (; position < this.array.length; position++) {
            if ((this.array[position]%this.array[position] ==0) | (this.array[position]%1 ==0)) {
                return position;
            }
        }
        return -1;
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
