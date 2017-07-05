package ru.napadovskiuB;

/**
 *
 * @param <E>
 */
public interface SimpleContainer<E> extends Iterable<E> {

    /**
     *
     * @param e
     */
    void add(E e);

    /**
     *
     * @param index
     * @return
     */
    E get(int index);
}
