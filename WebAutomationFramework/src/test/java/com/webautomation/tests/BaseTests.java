package com.webautomation.tests;


import org.testng.annotations.*;
import com.webautomation.driver.Driver;


public class BaseTests {

	protected BaseTests() {

	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		Driver.initDriver();
	}

	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}
	

}
