package ru.napadovskiyB;

import org.junit.Test;

import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 *
 */
public class MySimpleTreeTest {

    /**
     *
     */
    private MySimpleTree<Integer>  tree = new MySimpleTree<>();

    /**
     *
     */
    @Test
    public void whenAddElementSaucesThenReturnSize() {

        this.tree.add(1, 1);
        this.tree.add(1, 2);
        final int checkResult = 3;

        assertThat(this.tree.getSize(), is(checkResult));

    }

    /**
     *
     */
    @Test
    public void whenAddElementNotSaucesThenReturnSize() {

        this.tree.add(1, 1);
        this.tree.add(2, 2);

        int checkResult = 1;

        assertThat(this.tree.getListOfChild().size(), is(1));

    }


    /**
     *
     */
    @Test
    public void whenTreeIsBinaryThanReturnTrue() {
        this.tree.add(1, 1);
        this.tree.add(1, 2);
        this.tree.add(2, 3);


        assertThat(this.tree.isBinary(), is(true));
        //TreeSet tre = new TreeSet()

    }

    @Test
    public void whenAddthenTest() {
        this.tree.add(10);
        this.tree.add(5);
        this.tree.add(11);

    }


}