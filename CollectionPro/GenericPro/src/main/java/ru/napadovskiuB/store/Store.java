package ru.napadovskiuB.store;

/**
 *Interface for implements.
 * @param <T> generic.
 */
public interface Store<T extends Base> {

    /**
     *Method add value to storage.
     *@param value add value.
     */
    void add(T value);

    /**
     *Method update value in array.
     * @param position position for update.
     * @param newValue new value for update.
     */
    void update(int position, T newValue);

    /**
     *Method delete value from array.
     * @param t value for delete.
     */
    void delete(T t);

}
