package ru.napadovskiuB;

/**
 * Created by Программист on 18.07.2017.
 */
public interface MyMap<T, V> {

    boolean insert(T key, V value);
    
    V get(T key);
    
    boolean delete(T key);

}
