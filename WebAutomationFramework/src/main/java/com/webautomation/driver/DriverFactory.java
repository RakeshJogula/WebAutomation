package com.webautomation.driver;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.webautomation.enums.ConfigProperties;
import com.webautomation.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * <b>Info</b><br>
 * <b>Date</b> - Mar 9, 2022 <br>
 * <b>Time</b> - 2:24:22 PM <br>
 * <b>Project Name</b> - WebAutomationFramework <br>
 * <b>Package Name</b> - com.webautomation.driver <br>
 * 
 * <Pre>
 * Driver Factory - Send Driver Based on Execution type during run time
 * Class is declared as Final in order to avoid extending this class to other class
 * Constructor is declared as Private to avoid creating a new object
 * </Pre>
 * <br>
 * @author Rakesh Jogula
 * @version 1.0
 */


public final class DriverFactory {

	private DriverFactory() {		
	}
	
	/**
	 * 
	 * This method is called from Driver Class
	 * This method takes input browsername,version and runmode and return driver 
	 * @return WebDriver
	 * @param browser - chrome,firefox,ie
	 * @param version - browser version
	 */
	public static WebDriver getDriver(String browserName, String version) throws MalformedURLException {
		WebDriver webdriver = null;
		DesiredCapabilities capability = null;
		String runMode = PropertyUtils.get(ConfigProperties.RUNMODE);
		if (browserName.equalsIgnoreCase("chrome")) {
			if (runMode.equalsIgnoreCase("remote")) {
				capability = new DesiredCapabilities();
				capability.setBrowserName(browserName);
				capability.setVersion(version);
				webdriver = new RemoteWebDriver(new URL(""), capability);
			} else {
				WebDriverManager.chromedriver().setup();
				webdriver = new ChromeDriver();
			}
		} else if (browserName.equalsIgnoreCase("firefox")) {
			if (runMode.equalsIgnoreCase("remote")) {
				capability = new DesiredCapabilities();
				capability.setBrowserName(browserName);
				capability.setVersion(version);
				webdriver = new RemoteWebDriver(new URL(""), capability);
			} else {
				WebDriverManager.firefoxdriver().setup();
				webdriver = new FirefoxDriver();
			}
		}
		return webdriver;
	}
}
