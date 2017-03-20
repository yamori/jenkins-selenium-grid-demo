package org.kay.jenk_selenium_hello;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import junit.framework.TestCase;

public class WikipediaTest extends TestCase {

	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\tech_resources\\geckodriver-v0.15.0-win64\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\tech_resources\\chromedriver_win32\\chromedriver.exe");
	}

	// Verify wikipedia
	public void testWikipediaTitle() {

		WebDriver driver;
		driver = new ChromeDriver();

		driver.get("https://en.wikipedia.org/wiki/Main_Page");

		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		assertEquals(pageTitle, "Wikipedia, the free encyclopedia");

		driver.close();
	}

}
