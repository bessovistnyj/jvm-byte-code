package ru.napadovskiuB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Random;

/**
 * Created by Программист on 25.05.2017.
 */
public class PerfomensSpeed {

    /**
     *
     */
    private ArrayList<String> arrayList = new ArrayList<>();

    /**
     *
     */
    private LinkedList<String> linkedList = new LinkedList<>();

    /**
     *
     */
    private TreeSet<String> treeSet = new TreeSet<>();

    /**
     *
     */
    private  WorkWithCollection workWithCollection  = new WorkWithCollection();

    /**
     *
     */
    private String testString;

    /**
     *
     */
    final static int numberOfLines = 15000;

    /**
     *
     */
    final static int lengthString = 100;


    /**
     *
     */
    public void testAdd() {

        int stringLength;

        CreateRandomString createRandomString = new CreateRandomString();

        Random rn = new Random();

        stringLength = rn.nextInt(lengthString);

        testString = createRandomString.createRandomString(stringLength);

        System.out.println(this.workWithCollection.add(this.arrayList, this.testString, this.numberOfLines));
        System.out.println(this.workWithCollection.add(this.linkedList, this.testString, this.numberOfLines));
        System.out.println(this.workWithCollection.add(this.treeSet, this.testString, this.numberOfLines));

    }


    /**
     *
     */
    public void testDelete() {

        System.out.println(this.workWithCollection.delete(this.arrayList, numberOfLines));
        System.out.println(this.workWithCollection.delete(this.linkedList, numberOfLines));
        System.out.println(this.workWithCollection.delete(this.treeSet, numberOfLines));

    }


    public static void main(String[] args) {
        PerfomensSpeed testSpeed = new PerfomensSpeed();
        testSpeed.testAdd();
        testSpeed.testDelete();

    }

}
