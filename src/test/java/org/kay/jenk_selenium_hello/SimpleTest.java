package org.kay.jenk_selenium_hello;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {

	private int x = 1;
	private int y = 1;

	@Test
	public void testAddition() {
		int z = x + y;
		Assert.assertEquals(2, z);
	}
	
}
