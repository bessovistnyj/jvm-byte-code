package ru.napadovskiuB.CycleTest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Владелец on 10.07.2017.
 */
public class NodeTest {

    @Test
    public void TestNode() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first) ;
        boolean result = first.hasCycle(first);
        int a =1;

    }

}