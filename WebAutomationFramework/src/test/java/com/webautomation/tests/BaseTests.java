package com.webautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.webautomation.driver.Driver;

public class BaseTests {

	protected BaseTests() {

	}

	@BeforeMethod
	public void setUp() {
		Driver.initDriver();
	}

	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}
}
