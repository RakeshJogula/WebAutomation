package com.webautomation.pages;

import org.openqa.selenium.By;

import com.webautomation.enums.WaitStratergy;
import com.webautomation.factories.ExplictWaitFactory;
import com.webautomation.reports.ExtentLogger;

public class OrangeHRMLoginPage extends BasePage {

	private final By username = By.id("txtUsername");
	private final By password = By.id("txtPassword");
	private final By button = By.id("btnLogin");

	public OrangeHRMLoginPage enterUsername(String usernametext) {
		try {
			sendkeys(ExplictWaitFactory.performExplicitWait(username, WaitStratergy.PRESENCE), usernametext);
			ExtentLogger.pass("Enter Username" + usernametext,true);
		} catch (Exception e) {
			ExtentLogger.fail("Enter Username" + usernametext);
		}
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String passwordtext) {
		try {
			sendkeys(ExplictWaitFactory.performExplicitWait(password, WaitStratergy.PRESENCE), passwordtext);
			ExtentLogger.pass("Enter Password" + passwordtext,true);
		} catch (Exception e) {
			ExtentLogger.fail("Enter Password" + passwordtext);
		}
		return this;
	}

	public OrangeHRMHomePage clickLoginBtn() {
		try {
			click(ExplictWaitFactory.performExplicitWait(button, WaitStratergy.CLICKABLE));
			ExtentLogger.pass("Click on Login Button",true);
		} catch (Exception e) {
			ExtentLogger.fail("Click on Login Button");
		}
		return new OrangeHRMHomePage();
	}

	public String getTitle() {
		return getPageTitle();
	}
}
