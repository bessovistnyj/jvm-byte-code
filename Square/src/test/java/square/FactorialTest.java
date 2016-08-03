package square;

import org.junit.Assert;

import static org.hamcrest.core.Is.is;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactorialTest{
		
	@Test
	public void whenAllCorrect() {
		Factorial fact  = new Factorial(5);
		int result = fact.calculate();
		Assert.assertThat(result,is(120));
	}	

	@Test
	public void whenUnCorrect() {
		Factorial fact  = new Factorial(0);
		int result = fact.calculate();
		Assert.assertThat(result,is(1));
	}	
	
}