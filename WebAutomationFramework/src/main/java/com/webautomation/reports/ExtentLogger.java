package com.webautomation.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.webautomation.driver.DriverManager;
import com.webautomation.enums.ConfigProperties;
import com.webautomation.utils.PropertyUtils;

public final class ExtentLogger {

	private ExtentLogger() {

	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void pass(String message, boolean isScreenshotNeeded) throws Exception {
		if (PropertyUtils.get(ConfigProperties.PASSSTEPSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		} else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isScreenshotNeeded) {
		try {
			if (PropertyUtils.get(ConfigProperties.PASSSTEPSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
				ExtentManager.getExtentTest().fail(message,
						MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
			} else {
				fail(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void skip(String message, boolean isScreenshotNeeded) {
		try {
			if (PropertyUtils.get(ConfigProperties.PASSSTEPSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
				ExtentManager.getExtentTest().skip(message,
						MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
			} else {
				skip(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getBase64Image() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
