package ru.napadovskiuB;

/**
 * Created by Программист on 04.07.2017.
 */
public interface Store <T extends Base> {

    /**
     *
     */
    void add(T value);

    /**
     *
     * @param oldValue
     * @param newValue
     */
    void update(T oldValue, T newValue);

    /**
     *
     * @param t
     */
    T[] delete(T t);

}
