package napadovskiy_arrays;

import org.junit.Assert;

import static org.hamcrest.core.Is.is;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicateTest {
    
	@Test	
    public void whenAllCorrect() {
        String[] inputString = {"�","�","�","�","�","�","�","�","�","�","�","�","�"};
		RemoveDuplicate NewwArray = new RemoveDuplicate(inputString);
		String[] checked = {"�","�","�","�","�"};
		String[] result = NewwArray.removeDuplicate();
		Assert.assertThat(result,is(checked));

    }
	
}