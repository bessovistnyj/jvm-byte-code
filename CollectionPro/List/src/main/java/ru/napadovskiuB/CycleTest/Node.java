package ru.napadovskiuB.CycleTest;

/**
 * Created by Владелец on 10.07.2017.
 */
public class Node<T> {

    private T value;

    private Node<T> next;

    public Node (T value) {
        this.value = value;
        this.next = null;
    }

    public T getNext() {
        return (T) this.next;
    }

    public void setNext(T nextValue) {
        this.next = (Node<T>) nextValue;

    }

    boolean hasCycle(Node first) {
        boolean result = false;
        while (first.next != null) {
            Node tmpValue = first.next;
            if (tmpValue.next.equals(first) || tmpValue.next.equals(tmpValue)) {
                result = true;
            }
        }
        return result;
    }


}
