package com.webautomation.pages;

import org.openqa.selenium.By;

import com.webautomation.enums.WaitStratergy;


public class OrangeHRMLoginPage extends BasePage {
	
	private final By username = By.id("txtUsername");
	private final By password = By.id("txtPassword");
	private final By button =  By.id("btnLogin");
	
	public OrangeHRMLoginPage enterUsername(String usernametext) {
		sendkeys(username, usernametext,WaitStratergy.PRESENCE);
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String passwordtext) {
		sendkeys(password,passwordtext,WaitStratergy.PRESENCE);
		return this;
	}
	
	public OrangeHRMHomePage clickLoginBtn() {
		click(button,WaitStratergy.CLICKABLE);
		return new OrangeHRMHomePage();
	}

	public String getTitle() {
		return getPageTitle();
	}
}
