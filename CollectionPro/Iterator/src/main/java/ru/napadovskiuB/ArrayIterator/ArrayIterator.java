package ru.napadovskiuB.ArrayIterator;

import java.util.Iterator;

/**
 * Package of CollectionPro testTask.
 *
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 22.06.2017
 */
public class ArrayIterator implements Iterator {

    /**
     * Main array.
     */
    private final int[][] array;

    /**
     *Number of lines.
     */
    private int lines = 0;

    /**
     *Number of cells.
     */
    private int index = 0;

    /**
     *Constructor for ArrayIterator class.
     * @param array main array.
     */
    public ArrayIterator(final int[][] array) {

        this.array = array;

    }


    /**
     *Method check can move in array.
     * @return result.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;

        if (this.lines < this.array.length) {
            int[] singleArray = this.array[this.lines];
            if (this.index < singleArray.length) {
                result = true;
            }
        }

        return result;
    }


    /**
     * Method take next value from array.
     * @return result.
     */
    @Override
    public Object next() {
        Object result = null;
            if (hasNext()) {
                int[] singleArray = this.array[this.lines];
                for (; this.index < singleArray.length;) {
                    result = this.array[this.lines][this.index];
                    this.index++;
                     if (this.index == singleArray.length) {
                        this.index = 0;
                        this.lines++;
                     }
                    break;
                }
            }
        return result;
    }
}
