package org.kay.jenk_selenium_hello;

import junit.framework.TestCase;

public class SimpleTest extends TestCase {

	private int x = 1;
	private int y = 1;

	public void testAddition() {
		int z = x + y;
		assertEquals(2, z);
	}
	
}
