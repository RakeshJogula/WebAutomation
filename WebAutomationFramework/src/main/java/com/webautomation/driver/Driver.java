package com.webautomation.driver;

import java.util.Objects;
import org.openqa.selenium.chrome.ChromeDriver;
import com.webautomation.constants.FrameworkConstants;

public final class Driver {
	
	private Driver() {
		
	}
	
	public static void initDriver() {
		if (Objects.isNull(DriverManager.getDriver())) {
			System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath());
			DriverManager.setDriver(new ChromeDriver());
			DriverManager.getDriver().get("https://www.google.com/");
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.removeDriver();
		}
	}
}
