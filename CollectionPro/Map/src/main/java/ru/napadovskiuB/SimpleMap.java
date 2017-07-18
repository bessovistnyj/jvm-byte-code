package ru.napadovskiuB;


import java.util.Iterator;

/**
 * Class user.
 *
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 17.07.2017
 */
public class SimpleMap<T, V> implements MyMap<T, V> {

    /**
     *
     */
    private Entry[] table;

    /**
     *
     */
    private int defaultCapacity = 4;

    private int currentPosition = 0;

    /**
     *
     */
    public SimpleMap() {
        this.table = new Entry[defaultCapacity];

    }

    /**
     *
     * @param capacity
     */
    public SimpleMap(int capacity) {
        this.table = new Entry[capacity];
    }


    /**
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean insert( T key, V value ) {
        boolean result = true;
        int hashCode = hash(key);
        this.currentPosition = indexFor(hashCode, table.length);
        resizeTable();
        if (table[currentPosition] == null) {
            table[currentPosition] = new Entry(key, value);
        } else {
            result = false;
        }

        return result;

    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public V get( T key ) {
        int hashCode = hash(key);
        int index = indexFor(hashCode, table.length);

        return (V) table[index].getValue();

    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public boolean delete( T key ) {
        boolean result = true;
        int index = indexFor(key.hashCode(), table.length);
        if(this.table[index] != null) {
            this.table[index] = null;
        } else {
            result = false;
        }

        return result;
    }


    /**
     *
     * @param h
     * @param length
     * @return
     */
    private int indexFor(int h, int length) {
        return h & (length - 1);
    }


    private void resizeTable() {
        if (this.table.length * 0.75 <= this.currentPosition) {
            int newCapacity  = (this.table.length*2);
            Entry<T, V>[] newArray = new Entry[newCapacity];
            for (int j = 0; j < this.table.length-1; ++j) {
                Entry<T,V> checkElement;
                if ((checkElement = this.table[j]) != null)
                    newArray[hash(checkElement.getKey()) & (newCapacity - 1)] = checkElement;
            }
            this.table = newArray;
        }
    }

    private static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }



    public Iterator keyIterator() {
       return new Iterator<T>() {
           @Override
           public boolean hasNext() {
               return false;
           }

           @Override
           public T next() {
               return null;
           }
       };
   }

    public Iterator valueIterator() {
        return new Iterator<V>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public V next() {
                return null;
            }
        };
    }

    private class Entry<T, V> {
        private T key;
        private V value;

        public Entry( T key, V value ) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
