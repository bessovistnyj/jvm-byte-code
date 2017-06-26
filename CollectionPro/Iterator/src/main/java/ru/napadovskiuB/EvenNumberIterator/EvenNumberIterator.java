package ru.napadovskiuB.EvenNumberIterator;


import java.util.Iterator;

/**
 * Even number iterator.
 *
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 22.06.2017
 */
public class EvenNumberIterator implements Iterator {

    private int[] array;

    private int cursor = 0;

    public EvenNumberIterator(int[] array) {
        this.array = array;

    }


    private int checkEvenNumber() {
        int position = this.cursor;
        for (;position < this.array.length; position++) {
            if (this.array[position]%2 ==0) {
                return position;
            }
        }

        return  -1;
    }




    @Override
    public boolean hasNext() {
        boolean result = false;
        if (checkEvenNumber() !=-1) {
           result = true;
       }

        return result;
    }

    @Override
    public Object next() {
        Object result = null;
        this.cursor = checkEvenNumber();
        return  this.array[this.cursor++];


    }
}
