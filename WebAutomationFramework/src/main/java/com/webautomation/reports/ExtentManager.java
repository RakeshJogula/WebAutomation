package com.webautomation.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

	private ExtentManager() {

	}

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	static void setExtentTest(ExtentTest test) {
		if (Objects.nonNull(test)) {
			extentTest.set(test);
		}
	}

	static void removeCurrentReport() {
		extentTest.remove();
	}

}
