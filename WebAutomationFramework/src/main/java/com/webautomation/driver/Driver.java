package com.webautomation.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.webautomation.enums.ConfigProperties;
import com.webautomation.reports.ExtentLogger;
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
 * Driver class - Creates driver for test execution
 * Class is declared as Final in order to avoid extending this class to other class
 * Constructor is declared as Private to avoid creating a new object
 * </Pre>
 * <br>
 * @author Rakesh Jogula
 * @version 1.0
 */

public final class Driver {

	private Driver() {

	}

	/**
	 * Using Webdriver Manager to setup Browser<br>
	 * This method is called from BaseTest Class to Create a Driver session before
	 * execution of each test case<br>
	 * 
	 * @param browser - chrome,firefox,ie
	 */
	public static void initDriver(String browser) {
		if (Objects.isNull(DriverManager.getDriver())) {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				DriverManager.setDriver(new ChromeDriver());
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
			} else if (browser.equalsIgnoreCase("ie")) {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("ignoreZoomSetting", true);
				WebDriverManager.iedriver().setup();
				DriverManager.setDriver(new InternetExplorerDriver(caps));
			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.iedriver().setup();
				DriverManager.setDriver(new EdgeDriver());
			} else {
				ExtentLogger.skip("Invalid browser Name");
			}

			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
			DriverManager.getDriver().manage().window().maximize();
		}
	}

	/**
	 * To Quit Driver after each test case execution is completed and Driver session
	 * is closed
	 */
	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.removeDriver();
		}
	}
}
