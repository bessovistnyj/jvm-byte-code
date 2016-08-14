package napadovskiyArrays;

import org.junit.Assert;

import static org.hamcrest.core.Is.is;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateMatrixTest {
    
	@Test	
    public void whenAllCorrect() {
        RotateMatrix rotateMatrix = new RotateMatrix();
 		int [][]  checked = {{7,4,1},
							 {8,5,2},
							 {9,6,3}};
		
		int [][]  result =  {{1,2,3},
							 {4,5,6},
							 {7,8,9}};
		int[][] newMatrix = rotateMatrix.rotateArray(result);
		Assert.assertThat(newMatrix,is(checked));

    }
	
}
