package ru.napadovskiuB;

import org.junit.Test;

//import java.util.ArrayList;
import java.util.List;

//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;

/**
 * Created by Программист on 01.06.2017.
 */
public class ConvertListTest {

    /**
     * Method for test conversion from List too Array.
     */
    @Test
    public void toList() {
        ConvertList convertList = new ConvertList();

        final int[][]  checked = {{7, 4, 1},
                                  {8, 5, 2},
                                  {9, 6, 3}};

        List<Integer> resultList = convertList.toList(checked);

    }

}