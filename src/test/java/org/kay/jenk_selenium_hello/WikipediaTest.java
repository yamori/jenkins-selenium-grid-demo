package org.kay.jenk_selenium_hello;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikipediaTest {

	// Verify wikipedia
	@Test
	public void testWikipediaTitle() {

		WebDriver driver = null;

		WebDriverSupport driverSupport = new WebDriverSupport();
		driver = driverSupport.getWebDriver();
		driver.get("https://en.wikipedia.org/wiki/Main_Page");

		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "Wikipedia, the free encyclopedia");

		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchInput")));
		// wait.until(ExpectedConditions.
		// visibilityOfElementLocated(By.id("searchInput")));

		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));

		// try {
		// Thread.sleep(20000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		driver.findElement(By.id("searchInput")).sendKeys("Java");
		driver.findElement(By.id("searchInput")).sendKeys(Keys.RETURN);
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("Java"));

		pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "Java - Wikipedia");

		// driver.findElement(By.linkText("History")).click();
		//
		// pageTitle = driver.getTitle();
		// System.out.println(pageTitle);
		// assertEquals(pageTitle, "Portal:History - Wikipedia");

		driver.close();
		driver.quit();
	}

	// Empty test
	@Test
	public void testEmptyTest() {
		Assert.assertTrue(true);
	}

}
