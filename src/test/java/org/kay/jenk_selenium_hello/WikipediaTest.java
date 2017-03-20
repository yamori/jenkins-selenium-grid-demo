package org.kay.jenk_selenium_hello;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import junit.framework.TestCase;

public class WikipediaTest extends TestCase {

	private DesiredCapabilities desiredCapabilities;

	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\tech_resources\\geckodriver-v0.15.0-win64\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\tech_resources\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "C:\\tech_resources\\IEDriverServer_Win32_3.3.0\\IEDriverServer.exe");

//		this.desiredCapabilities = DesiredCapabilities.firefox();
//		this.desiredCapabilities.setBrowserName("firefox");
//		this.desiredCapabilities.setCapability("marionette", true);
//		this.desiredCapabilities.setPlatform(Platform.XP);
		
		this.desiredCapabilities = DesiredCapabilities.internetExplorer();
		this.desiredCapabilities.setBrowserName("internet explorer");
		this.desiredCapabilities.setPlatform(Platform.XP);
	}

	// Verify wikipedia
	public void testWikipediaTitle() {

		WebDriver driver = null;
		try {
			System.out.println("<-- geckoDriverLocation: " + System.getProperty("webdriver.gecko.driver"));
			System.out.println("<-- IEDriverLocation: " + System.getProperty("webdriver.ie.driver"));
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), this.desiredCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.get("https://en.wikipedia.org/wiki/Main_Page");

		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		assertEquals(pageTitle, "Wikipedia, the free encyclopedia");

		driver.close();
	}

	// Empty test
	public void testEmptyTest() {
		assertTrue(true);
	}

}
