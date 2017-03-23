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

		String queryString = "Java";
		String targetPageTitle = queryString + " - Wikipedia";
		driver.findElement(By.id("searchInput")).sendKeys(queryString);
		driver.findElement(By.id("searchInput")).sendKeys(Keys.RETURN);

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains(queryString));

		pageTitle = driver.getTitle();
		if (pageTitle.compareToIgnoreCase(targetPageTitle) != 0) {
			// Sometimes wikipedia returns the "search results page" instead"
			driver.get("https://en.wikipedia.org/wiki/" + queryString);
		}

		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains(queryString));

		pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, targetPageTitle);
		// //////////////////////////////////////////////////////////////////////////////

		queryString = "Rome";
		targetPageTitle = queryString + " - Wikipedia";
		driver.findElement(By.id("searchInput")).sendKeys(queryString);
		driver.findElement(By.id("searchInput")).sendKeys(Keys.RETURN);

		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains(queryString));

		pageTitle = driver.getTitle();
		if (pageTitle.compareToIgnoreCase(targetPageTitle) != 0) {
			// Sometimes wikipedia returns the "search results page" instead"
			driver.get("https://en.wikipedia.org/wiki/" + queryString);
		}

		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains(queryString));

		pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, targetPageTitle);
		// //////////////////////////////////////////////////////////////////////////////

		queryString = "Calculus";
		targetPageTitle = queryString + " - Wikipedia";
		driver.findElement(By.id("searchInput")).sendKeys(queryString);
		driver.findElement(By.id("searchInput")).sendKeys(Keys.RETURN);

		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains(queryString));

		pageTitle = driver.getTitle();
		if (pageTitle.compareToIgnoreCase(targetPageTitle) != 0) {
			// Sometimes wikipedia returns the "search results page" instead"
			driver.get("https://en.wikipedia.org/wiki/" + queryString);
		}

		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains(queryString));

		pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, targetPageTitle);
		// //////////////////////////////////////////////////////////////////////////////

		driverSupport.closeWebDriver(driver);
	}

	// Empty test
	@Test
	public void testEmptyTest() {
		Assert.assertTrue(true);
	}

}
