package napadovskiyArrays;

import org.junit.Assert;

import static org.hamcrest.core.Is.is;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {
    
	@Test	
    public void whenAllCorrect() {
        BubbleSort bubbleSort = new BubbleSort();
 		int [] checked = new int[]{0, 1, 2, 3, 4, 5};
		int [] result = new int[]{3, 5, 0, 2, 4, 1};
		bubbleSort.sortArray(result);
		Assert.assertThat(result,is(checked));

    }
	
}