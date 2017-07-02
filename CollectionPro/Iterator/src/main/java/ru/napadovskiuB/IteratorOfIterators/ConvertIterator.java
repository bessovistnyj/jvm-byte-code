package ru.napadovskiuB.IteratorOfIterators;

import java.util.Iterator;

/**
 * Even number iterator.
 *
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 01.07.2017
 */
public interface ConvertIterator {

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it);
}
