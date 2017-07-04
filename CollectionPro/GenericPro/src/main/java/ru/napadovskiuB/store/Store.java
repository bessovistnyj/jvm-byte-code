package ru.napadovskiuB.store;

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
     * @param position
     * @param newValue
     */
    void update(int position, T newValue);

    /**
     *
     * @param t
     */
    void delete(T t);

}
