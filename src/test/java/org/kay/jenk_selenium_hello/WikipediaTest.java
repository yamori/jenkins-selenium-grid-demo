package org.kay.jenk_selenium_hello;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import junit.framework.TestCase;

public class WikipediaTest extends TestCase {

	// Verify wikipedia
	public void testWikipediaTitle() {

		WebDriver driver = null;

		WebDriverSupport driverSupport = new WebDriverSupport();
		driver = driverSupport.getWebDriver();
		driver.get("https://en.wikipedia.org/wiki/Main_Page");

		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		assertEquals(pageTitle, "Wikipedia, the free encyclopedia");
		
		driver.findElement(By.id("searchInput")).sendKeys("Java");
		driver.findElement(By.id("searchInput")).sendKeys(Keys.RETURN);

		driver.quit();
	}

	// Empty test
	public void testEmptyTest() {
		assertTrue(true);
	}

}
