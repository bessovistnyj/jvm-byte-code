package napadovskiy_arrays;

import org.junit.Assert;

import static org.hamcrest.core.Is.is;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateMatrixTest {
    
	@Test	
    public void whenAllCorrect() {
        RotateMatrix rotateMatrix = new RotateMatrix();
 		int [][]  checked = {{1,5,9,13},
							 {2,6,10,14},
							 {3,7,11,15},
							 {4,8,12,16}};
		
		int [][]  result =  {{1,2,3,4},
							 {5,6,7,8},
							 {9,10,11,12},
							 {13,14,15,16}};
		int[][] newMatrix = rotateMatrix.RotateArray(result);
		Assert.assertThat(newMatrix,is(checked));

    }
	
}
