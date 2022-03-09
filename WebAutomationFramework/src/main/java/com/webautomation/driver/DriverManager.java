package com.webautomation.driver;

import org.openqa.selenium.WebDriver;

/**
 * 
 * <b>Info</b><br>
 * <b>Date</b> - Mar 9, 2022 <br>
 * <b>Time</b> - 2:29:23 PM <br>
 * <b>Project Name</b> - WebAutomationFramework <br>
 * <b>Package Name</b> - com.webautomation.driver <br>
 * <pre>DriverManger - Manages All Driver objects created during Execution <br></pre>
 * Class is declared as Final in order to avoid extending this class to other
 * class<br>
 * Constructor is declared as Private to avoid creating a new object<br>
 * 
 * @author Rakesh Jogula
 * @version 1.0
 */

public final class DriverManager {

	private DriverManager() {

	}

	private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void setDriver(WebDriver driverref) {
		dr.set(driverref);
	}

	public static void removeDriver() {
		dr.remove();
	}

}
