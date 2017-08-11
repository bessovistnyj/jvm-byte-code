package ru.napadovskiyB;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class CheckStringTest {

    String checkString = "a baba galamaga   for ";

    @Test
    public void whenCalculateWordsThenReturnCount() {
        CheckString checkString = new CheckString(this.checkString);
        int resultCalc = checkString.calcWorlds();
        assertThat(resultCalc, is(4));
    }

    @Test
    public void whenCalculateSpaceBarThenReturnCount() {
        CheckString checkString = new CheckString(this.checkString);
        int resultCalc = checkString.calcSpace();
        assertThat(resultCalc, is(6));


    }



}