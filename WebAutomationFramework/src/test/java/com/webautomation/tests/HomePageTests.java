package com.webautomation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.webautomation.driver.DriverManager;

public final class HomePageTests extends BaseTests{
	
	private HomePageTests() {
		
	}
	
	@Test
	public void test3() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("API Automation Test Jobs", Keys.ENTER);
	}

	@Test
	public void test4() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Manual Test Job", Keys.ENTER);
	}

}
