package com.webautomation.pages;

import org.openqa.selenium.By;

import com.webautomation.driver.DriverManager;
import com.webautomation.enums.WaitStratergy;
import com.webautomation.factories.ExplictWaitFactory;

public class BasePage {
	
	protected void click(By by,WaitStratergy waitStratergy) {
		ExplictWaitFactory.performExplicitWait(by, waitStratergy).click();
	}
	
	protected void sendkeys(By by,String text,WaitStratergy waitStratergy){
		ExplictWaitFactory.performExplicitWait(by, waitStratergy).sendKeys(text);
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	

}
