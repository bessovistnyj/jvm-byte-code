package ru.napadovskiuB.LinkedList;


import ru.napadovskiuB.SimpleContainer;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Владелец on 05.07.2017.
 */
public class SimpleLinkedList<E> implements SimpleContainer{

    /**
     *
     */
    private int size = 0;

    private int currentIndex = 0;

    /**
     *
     */
    private SimpleCell<E> first;



    /**
     *
     */
    private SimpleCell<E> last;


    @Override
    public void add(Object o ) {
        final SimpleCell<E> tmpCell = this.last;
        final SimpleCell<E> newNode = new SimpleCell<E>(tmpCell, (E) o, null);
        this.last = newNode;
        if (tmpCell == null)
            this.first = newNode;
        else
            tmpCell.next = newNode;
        this.size++;
        this.currentIndex++;
    }

    /**
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object get(int index ) {
        checkIndex(index);
        return simpleCell(index);
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return  currentIndex < size-1;

            }

            @Override
            public Object next() {
                if (hasNext()) {
                    int current = currentIndex;
                    currentIndex++;
                    return get(current);
                }
                throw new NoSuchElementException();
            }
        };
    }


    SimpleCell<E> simpleCell(int index) {
        if(index < this.size) {
            SimpleCell<E> tmpCell = this.first;
            for (int i = 0; i < index; i++) {
                tmpCell = tmpCell.next;
            }
            return tmpCell;

        } else{
            SimpleCell<E> tmpCell = this.last;
            for (int i = size - 1; i > index; i--)
                tmpCell = tmpCell.prev;
            return tmpCell;
        }
    }


    private class SimpleCell<E> {
        E item;
        SimpleCell<E> next;
        SimpleCell<E> prev;

        public SimpleCell(SimpleCell<E> prev, E element, SimpleCell<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
