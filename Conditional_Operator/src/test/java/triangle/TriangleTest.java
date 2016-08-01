package triangle;

import org.junit.Assert;

import static org.hamcrest.core.Is.is;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {
    
	@Test	
    public void whenRightCoordinateShouldReturnArea() {
		//assign block
		Point vertexA = new Point(0,0.0);
		Point vertexB = new Point(0,3);
		Point vertexC = new Point(4,0);
		
		Triangle triangle = new Triangle(vertexA ,vertexB ,vertexC );
		
		//act block
		double result = triangle.area();
		
		//assert block
		Assert.assertThat(result,is(6d));

    }

	@Test	
    public void whenWrongCoordinateShouldReturnArea() {
		//assign block
		Point vertexA = new Point(0.0,0.0);
		Point vertexB = new Point(0.0,0.0);
		Point vertexC = new Point(3.0,26.0);
		
		Triangle triangle = new Triangle(vertexA ,vertexB ,vertexC );
		
		//act block
		double result = triangle.area();
		
		//assert block
		Assert.assertThat(result,is(-1.0d));

    }
	
}