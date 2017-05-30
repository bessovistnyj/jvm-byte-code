package ru.napadovskiuB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Random;

/**
<<<<<<< HEAD
 * Created by Napadovskiy on 25.05.2017.
=======
 * Created by napadovskiuB on 25.05.2017.
>>>>>>> 48a903de654ac10c8f32e95fc512153901c311fb
 */
public class PerfomensSpeed {

    /**
<<<<<<< HEAD
     * Array list for speed testing.
=======
     * Array list for checking.
>>>>>>> 48a903de654ac10c8f32e95fc512153901c311fb
     */
    private ArrayList<String> arrayList = new ArrayList<String>();

    /**
<<<<<<< HEAD
     * Linked list  for speed testing.
=======
     * Linked list for checking.
>>>>>>> 48a903de654ac10c8f32e95fc512153901c311fb
     */
    private LinkedList<String> linkedList = new LinkedList<String>();

    /**
<<<<<<< HEAD
     * Tree for speed testing.
=======
     * Tree set for checking.
>>>>>>> 48a903de654ac10c8f32e95fc512153901c311fb
     */
    private TreeSet<String> treeSet = new TreeSet<String>();

    /**
<<<<<<< HEAD
     * Class for work with collection.
     */
    private  WorkWithCollection workWithCollection  = new WorkWithCollection();

     /**
     * Number of lines for add to Collection.
     */
    private static final int NUMBERLINES = 15000;

    /**
     * Length of strings to generate random string.
     */
    private static final int LENGTHSTRING = 100;


    /**
     * Method for test add strings to collection.
=======
     *  Class with method's for checking speed.
     */
    private  WorkWithCollection workWithCollection  = new WorkWithCollection();

    /**
     * string for add in collection.
     */
    private String testString;

    /**
     * number of strings to add in collection.
     */
    private final int numberOfLines = 15000;

    /**
     * length string for generate random string.
     */
    private final int lengthString = 100;


    /**
     * method test speed add string to collection.
>>>>>>> 48a903de654ac10c8f32e95fc512153901c311fb
     */
    public void testAdd() {

        int stringLength;

        String testString;
        CreateRandomString createRandomString = new CreateRandomString();

        Random rn = new Random();

        stringLength = rn.nextInt(this.LENGTHSTRING);

        testString = createRandomString.createRandomString(stringLength);

        System.out.println(this.workWithCollection.add(this.arrayList, testString, this.NUMBERLINES));
        System.out.println(this.workWithCollection.add(this.linkedList, testString, this.NUMBERLINES));
        System.out.println(this.workWithCollection.add(this.treeSet, testString, this.NUMBERLINES));

    }


    /**
<<<<<<< HEAD
     * Method for test delete strings to collection.
     */
    public void testDelete() {

        System.out.println(this.workWithCollection.delete(this.arrayList, this.NUMBERLINES));
        System.out.println(this.workWithCollection.delete(this.linkedList, this.NUMBERLINES));
        System.out.println(this.workWithCollection.delete(this.treeSet, this.NUMBERLINES));

    }

=======
     * method tests deleting speed from collection.
     */
    public void testDelete() {

        System.out.println(this.workWithCollection.delete(this.arrayList, numberOfLines));
        System.out.println(this.workWithCollection.delete(this.linkedList, numberOfLines));
        System.out.println(this.workWithCollection.delete(this.treeSet, numberOfLines));

    }
>>>>>>> 48a903de654ac10c8f32e95fc512153901c311fb
}
