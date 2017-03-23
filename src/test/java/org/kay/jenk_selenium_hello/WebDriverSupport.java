package org.kay.jenk_selenium_hello;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverSupport {

	// Helps interpret the execution environment and supplies an appropriate
	// Selenium webdriver

	final static String ENV_VAR_NAME = "MYLAPTOP";

	private boolean isMyLaptop() {
		String localIndicator = System.getenv("MYLAPTOP");
		System.out.println(localIndicator);

		if (localIndicator != null && localIndicator.compareToIgnoreCase("yes") == 0) {
			System.out.println("Environment detected: environment variable " + ENV_VAR_NAME);

			// By instantiating the Singleton, system properties are set.
			@SuppressWarnings("unused")
			SystemPropertiesSingleton systemPropertiesSingleton = new SystemPropertiesSingleton();

			return true;
		} else {
			System.out.println("Target environment detected: otherwise you need to set " + ENV_VAR_NAME);
			return false;
		}
	}

	public WebDriver getWebDriver() {
		WebDriver driver = null;

		DesiredCapabilities desiredCapabilities;

		if (isMyLaptop()) {
			// Standard Selenium
			driver = new ChromeDriver();
		} else {
			// Remote web driver (and assumed that Selenium Grid-Hub is ready)

			// desiredCapabilities = DesiredCapabilities.internetExplorer();
			// desiredCapabilities.setBrowserName("internet explorer");
			// desiredCapabilities.setPlatform(Platform.XP);
			// try {
			// driver = new RemoteWebDriver(new
			// URL("http://localhost:4444/wd/hub"), desiredCapabilities);
			// } catch (MalformedURLException e) {
			// e.printStackTrace();
			// }

			desiredCapabilities = DesiredCapabilities.firefox();
			desiredCapabilities.setBrowserName("firefox");
			desiredCapabilities.setPlatform(Platform.XP);
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		return driver;
	}

	public void closeWebDriver(WebDriver driver) {
		/*
		 * Depending on the environment, different methods will need to be used
		 * to close/quit the browser.
		 */
		
		if (isMyLaptop()) {
			driver.quit();
		} else {
			driver.close();
		}
	}

}
