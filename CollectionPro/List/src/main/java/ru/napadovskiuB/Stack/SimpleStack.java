package ru.napadovskiuB.Stack;

import ru.napadovskiuB.LinkedList.SimpleLinkedList;

/**
 * Package of CollectionPro testTask.
 *
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @param <E> generic.
 * @since 08.07.2017
 */
public class SimpleStack<E> extends SimpleLinkedList<E> {

    /**
     *Method return value from Stack.
     * @return value
     */
    public E peek() {
        return get(getSize() - 1);
    }

    /**
     * Method add element to Stack.
     * @param e value.
     */
    public void push(E e) {
        add(e);

    }

    /**
     *Method return element from Stack end delete it.
     * @return value.
     */
    public E pop() {
        E result = get(getSize() - 1);
        removeElement(getSize() - 1);
        return  result;
    }

}
