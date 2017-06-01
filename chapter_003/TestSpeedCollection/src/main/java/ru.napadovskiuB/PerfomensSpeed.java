package ru.napadovskiuB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by napadovskiuB on 25.05.2017.
 */
public class PerfomensSpeed {

    /**
     * Array list for speed testing.

     */
    private ArrayList<String> arrayList = new ArrayList<String>();

    /**
     * Linked list for checking.
     */
    private LinkedList<String> linkedList = new LinkedList<String>();

    /**
     * Tree for speed testing.

     */
    private TreeSet<String> treeSet = new TreeSet<String>();

    /**
     * Number of lines for add to Collection.
     */
    private static final int NUMBERLINES = 15000;

     /**
     *  Class with method's for checking speed.
     */
    private  WorkWithCollection workWithCollection  = new WorkWithCollection();

    /**
     * method test speed add string to collection.
     */
    public void testAdd() {

        System.out.println(this.workWithCollection.add(this.arrayList,  this.NUMBERLINES));
        System.out.println(this.workWithCollection.add(this.linkedList,  this.NUMBERLINES));
        System.out.println(this.workWithCollection.add(this.treeSet,  this.NUMBERLINES));
    }


    /**
     * Method for test delete strings to collection.
     */
    public void testDelete() {

        System.out.println(this.workWithCollection.delete(this.arrayList,  this.NUMBERLINES));
        System.out.println(this.workWithCollection.delete(this.linkedList,  this.NUMBERLINES));
        System.out.println(this.workWithCollection.delete(this.treeSet,  this.NUMBERLINES));

    }



}
