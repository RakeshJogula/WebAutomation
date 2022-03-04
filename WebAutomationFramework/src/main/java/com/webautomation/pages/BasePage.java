package com.webautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.webautomation.driver.DriverManager;



public class BasePage {
	
	protected void click(WebElement element) {
		element.click();
	}
	
	protected void sendkeys(WebElement element,String text){
		element.clear();
		element.sendKeys(text);
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	protected void selectByVisibleText(WebElement element,String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

}
