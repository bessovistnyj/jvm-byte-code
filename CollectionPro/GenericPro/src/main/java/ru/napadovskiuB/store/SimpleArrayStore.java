package ru.napadovskiuB.store;


/**
 *Base class.
 * @param <T> generic.
 */
public class SimpleArrayStore<T extends Base> implements Store {

    /**
     *Array for elements.
     */
    private Object[] objects;

    /**
     *cursor on current index of Array.
     */
    private int currentPosition;

    /**
     *Constructor for array store with size.
     * @param size array size.
     */
    public SimpleArrayStore(int size) {
        this.objects = new Object[size];
        this.currentPosition = 0;
    }

    /**
     *Method return value by index.
     * @param index index.
     * @return value.
     */
    public Base get(int index) {
        return (Base) this.objects[index];
    }

    /**
     *Method add value to array.
     * @param value
     */
    @Override
    public void add(Base value) {
        this.objects[currentPosition++] = value;
    }

    /**
     * Method update value in array.
     * @param position position.
     * @param newValue new value.
     */
    @Override
    public void update(int position, Base newValue) {
        this.objects[position] = newValue;

    }

    /**
     *Method delete value from array.
     * @param base
     */
    @Override
    public void delete(Base base) {
        for (int i = 0; i < this.objects.length; i++) {
            if (this.objects[i].equals(base)) {
                objects[i] = null;
            }
        }
    }
}
