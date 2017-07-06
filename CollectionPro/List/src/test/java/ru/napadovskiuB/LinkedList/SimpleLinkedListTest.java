package ru.napadovskiuB.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Программист on 06.07.2017.
 */
public class SimpleLinkedListTest {

    @Test
    public void TestAdd() {
        SimpleLinkedList<String> simpleLinkedList = new SimpleLinkedList<String>();
        simpleLinkedList.add("string1");
        simpleLinkedList.add("string2");
        simpleLinkedList.add("string3");
        simpleLinkedList.add("string4");

    }

    @Test
    public void TestGet() {
        SimpleLinkedList<String> simpleLinkedList = new SimpleLinkedList<String>();
        simpleLinkedList.add("string1");
        simpleLinkedList.add("string2");
        simpleLinkedList.add("string3");
        simpleLinkedList.add("string4");
        Object result = simpleLinkedList.get(0);

        int a =1;


    }


}