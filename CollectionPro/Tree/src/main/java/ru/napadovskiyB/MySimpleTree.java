package ru.napadovskiyB;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @param <E>
 */
class MySimpleTree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     *
     */
    private Node<E> root;



    /**
     *
     * @param first
     * @param second
     * @return
     */
    public Node<E> search(Node<E> first, E second) {
        Node<E> result = null;

        if (first.value.compareTo(second) == 0) {
            result = first;
        }

      return result;
    }


    /**
     *
     * @param parent parent.
     * @param child child.
     * @return
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = true;
        if (this.root == null) {
            this.root = new Node<>(parent);
            this.root.children.add(new Node<>(child));
        } else {
            Node<E> root = search(this.root, parent);
            if (root != null) {
                result = root.children.add(new Node<>(child));
            }
        }
        return result;
    }

    /**
     *
     * @param <E>
     */
    private class Node<E> {
        private List<Node<E>> children;
        private E value;

        /**
         *
         * @param value
         */
        public Node(E value) {
            this.value = value;
            this.children = new LinkedList<>();

        }

        /**
         *
         * @param o
         * @return
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Node<?> node = (Node<?>) o;

            if (children != null ? !children.equals(node.children) : node.children != null) return false;

            return value != null ? value.equals(node.value) : node.value == null;
        }

        /**
         *
         * @return
         */
        @Override
        public int hashCode() {
            final int var  = 31;
            int result = children != null ? children.hashCode() : 0;
            result =  var * result + (value != null ? value.hashCode() : 0);
            return result;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            /**
             *
             * @return
             */
            @Override
            public boolean hasNext() {
                return false;
            }

            /**
             *
             * @return
             */
            @Override
            public E next() {
                return null;
            }
        };
    }
}