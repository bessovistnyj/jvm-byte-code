package ru.napadovskiyB;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

/**
 * Class implements interface SimpleTree.
 * extends Comparable.
 * @param <E> generic
 */
class MySimpleTree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * root element.
     */
    private Node<E> root;

    /**
     * Method check element with parent.
     * @param first element for check.
     * @param second element with check
     * @return result.
     */
    public Node<E> search(Node<E> first, E second) {
        Node<E> result = null;

        if (first.value.compareTo(second) == 0) {
            result = first;
        } else {
            for (Node<E> child : first.children) {
                result = search(child, second);
            }
        }

      return result;
    }

    /**
     * Method return list children of root.
     * @return child list.
     */
    public List<Node<E>> getListOfChild() {
        return root.getChildren();
    }

    /**
     * Method add element to collection.
     * @param parent parent.
     * @param child child.
     * @return result.
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
            } else {
                result = false;
            }
        }
        return result;
    }

     /**
     * Inner class for save element.
     * @param <E> generic.
     */
    private class Node<E> {
        /**
         * list with child element.
         */
        private List<Node<E>> children;

        /**
         * value element.
         */
        private E value;

        /**
         * Constructor with parameters.
         * @param value for add.
         */
        Node(E value) {
            this.value = value;
            this.children = new LinkedList<>();

        }

         /**
          * Method return list of children.
          * @return list.
          */
        public List<Node<E>> getChildren() {
            return children;
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