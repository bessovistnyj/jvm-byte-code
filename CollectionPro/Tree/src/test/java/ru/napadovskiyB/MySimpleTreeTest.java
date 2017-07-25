package ru.napadovskiyB;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 *
 */
public class MySimpleTreeTest {

    /**
     *
     */
    private MySimpleTree<String>  tree = new MySimpleTree<>();

    /**
     *
     */
    @Test
    public void whenAddElementSaucesThenReturnSize() {

        this.tree.add("FirstElement", "FirstChild");
        this.tree.add("FirstElement", "SecondChild");
        final int checkResult = 3;

        assertThat(this.tree.getSize(), is(checkResult));

    }

    /**
     *
     */
    @Test
    public void whenAddElementNotSaucesThenReturnSize() {

        this.tree.add("FirstElement", "FirstChild");
        this.tree.add("SecondElement", "SecondChild");

        int checkResult = 1;

        assertThat(this.tree.getListOfChild().size(), is(1));

    }


    /**
     *
     */
    @Test
    public void whenTreeIsBinaryThanReturnTrue() {
        this.tree.add("FirstElement", "FirstChild");
        this.tree.add("FirstChild", "SecondChild");
        this.tree.add("SecondChild", "ThirdChild");
        this.tree.add("SecondChild", "ThortChild");

        assertThat(this.tree.isBinary(), is(true));

    }

}