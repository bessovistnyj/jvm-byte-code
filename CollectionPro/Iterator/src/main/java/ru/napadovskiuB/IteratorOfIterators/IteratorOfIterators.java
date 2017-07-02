package ru.napadovskiuB.IteratorOfIterators;

import java.util.Iterator;

/**
 * Even number iterator.
 *
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 01.07.2017
 */
public class IteratorOfIterators implements ConvertIterator,Iterator <Integer> {

    /**
     *
     */
    private Iterator<Iterator<Integer>> iteratorOfIterator;

    /**
     *
     */
    private Iterator <Integer> currentIterator ;

    /**
     *
     * @param it
     * @return
     */
    @Override
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.iteratorOfIterator = it;
        if (it.hasNext()) {
            this.currentIterator.next();
        }
        return this;
    }

    /**
     *
     * @param it
     */
    public IteratorOfIterators(Iterator<Iterator<Integer>> it) {
        this.iteratorOfIterator = it;
        this.currentIterator = it.next();
    }

    /**
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        if (!currentIterator.hasNext()) {
            if (iteratorOfIterator.hasNext()) {
                this.currentIterator = iteratorOfIterator.next();
            }
        }
        return currentIterator.hasNext();
    }

    /**
     *
     * @return
     */
    @Override
    public Integer next() {
        if (!currentIterator.hasNext()) {
            if (iteratorOfIterator.hasNext()) {
                this.currentIterator = iteratorOfIterator.next();
            }
        }
        this.currentIterator = iteratorOfIterator.next();
        return this.currentIterator.next();
    }
}
