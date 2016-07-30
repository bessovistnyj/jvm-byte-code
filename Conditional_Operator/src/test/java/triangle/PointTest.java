package triangle;

import org.junit.Assert;

import static org.hamcrest.core.Is.is;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    
	@Test	
    public void WhenRightCoordinatShouldReturnDistance() {
		//assign block
		Point firstpoint = new Point(0.0,2.0);
		
		Point secondpoint = new Point(3.0,6.0);
		
		//act block
		double result = firstpoint.distanceTo(secondpoint);
		
		//assert block
		Assert.assertThat(result,is(5.0d));

    }

	@Test
    public void WhenUncorectCoordinatShouldReturnDistance() {
		//assign block
		Point firstpoint = new Point(0.0,0.0);
		
		Point secondpoint = new Point(0.0,0.0);
		
		//act block
		double result = firstpoint.distanceTo(secondpoint);
		
		//assert block
		Assert.assertThat(result,is(0.0d));

    }

	
}