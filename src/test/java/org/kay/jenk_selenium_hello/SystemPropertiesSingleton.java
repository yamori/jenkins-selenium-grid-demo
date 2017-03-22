package org.kay.jenk_selenium_hello;

public class SystemPropertiesSingleton {
	/*
	 * Single class which sets all system properties. Needs to be invoked before
	 * any webdrivers are established.
	 */

	private static SystemPropertiesSingleton instance = null;

	protected SystemPropertiesSingleton() {
		// Exists only to defeat instantiation.
		System.setProperty("webdriver.gecko.driver", "C:\\tech_resources\\geckodriver-v0.15.0-win64\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\tech_resources\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "C:\\tech_resources\\IEDriverServer_Win32_3.3.0\\IEDriverServer.exe");
	}

	public static SystemPropertiesSingleton getInstance() {
		if (instance == null) {
			instance = new SystemPropertiesSingleton();
		}
		return instance;
	}

}
