package square;

import org.junit.Assert;

import static org.hamcrest.core.Is.is;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {
    
	@Test	
    public void whenAllCorrect() {
        Square square = new Square(1,2,3);
        double check = 11;
		double result = square.calculate(2);
        Assert.assertThat(result,is(check));

    }
	
		
}
	
