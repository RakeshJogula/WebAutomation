package com.webautomation.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webautomation.driver.DriverManager;
import com.webautomation.enums.WaitStratergy;



public class ExplictWaitFactory {
	
	
	private ExplictWaitFactory() {
		
	}
	
	@SuppressWarnings("deprecation")
	public static WebElement performExplicitWait(By by, WaitStratergy wait) {
		WebElement element = null;
		if (wait == WaitStratergy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), 10)
					.until(ExpectedConditions.elementToBeClickable(by));
		} else if (wait == WaitStratergy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(), 10)
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} else if (wait == WaitStratergy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(), 10)
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else if (wait == WaitStratergy.NONE) {
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}

}
