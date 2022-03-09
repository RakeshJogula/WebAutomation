package com.webautomation.tests;


import java.util.HashMap;

import org.testng.annotations.*;
import com.webautomation.driver.Driver;


public class BaseTests {

	protected BaseTests() {

	}
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	public void setUp(Object[] browserdata) throws Exception {
		HashMap<String,String> test = (HashMap<String, String>) browserdata[0];
		System.out.println(test.get("Browser"));
		Driver.initDriver(test.get("Browser"));
	}

	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}
	

}
