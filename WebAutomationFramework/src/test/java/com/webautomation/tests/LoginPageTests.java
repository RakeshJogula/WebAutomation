package com.webautomation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.webautomation.driver.DriverManager;


public final class LoginPageTests extends BaseTests{

	private LoginPageTests() {
		
	}

	@Test
	public void test1() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Web Automation Test Jobs", Keys.ENTER);
	}

	@Test
	public void test2() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Mobile Automation Test Job", Keys.ENTER);
	}
	


}
