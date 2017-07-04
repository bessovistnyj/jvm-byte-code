package ru.napadovskiuB.store;

/**
 * Created by Владелец on 04.07.2017.
 */
public class SimpleArrayStore<T extends Base> implements Store{

    /**
     *Array for elements.
     */
    private Object[] objects;

    /**
     *cursor on current index of Array.
     */
    private int currentPosition;

    public SimpleArrayStore(int size) {
        this.objects = new Object[size];
        this.currentPosition = 0;
    }

    @Override
    public void add(Base value) {
        this.objects[currentPosition++] = value;
    }

    @Override
    public void update(int position, Base newValue) {
        this.objects[position] = newValue;

    }

    @Override
    public void delete(Base base) {
        for (int i = 0; i < this.objects.length; i++) {
            if (this.objects[i].equals(base)) {
                objects[i] = null;
            }
        }

    }
}
