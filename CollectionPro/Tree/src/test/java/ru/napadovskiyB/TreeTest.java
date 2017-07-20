package ru.napadovskiyB;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class TreeTest {

    @Test
    public void TestAddElementsToTree() {
        MySimpleTree<String>  tree = new MySimpleTree<>();

        tree.add("FirstElement", "FirstChild");
        tree.add("FirstElement", "SecondChild");
        int a =1;
    }


}