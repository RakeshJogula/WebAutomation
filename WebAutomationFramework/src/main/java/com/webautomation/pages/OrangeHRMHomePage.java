package com.webautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.webautomation.enums.WaitStratergy;
import com.webautomation.factories.ExplictWaitFactory;

public class OrangeHRMHomePage extends BasePage {
	
	private final By link_welcome = By.id("welcome");
	private final By link_logout = By.xpath("//a[text()='Logout']");
	private final By link_myInfo = By.id("menu_pim_viewMyDetails");
	private final By btn_edit = By.xpath("//input[@value='Edit']");
	private final By txt_firstName = By.id("personal_txtEmpFirstName");
	private final By txt_middleName = By.id("personal_txtEmpMiddleName");
	private final By txt_lastName = By.id("personal_txtEmpLastName");
	private final By txt_employeeId = By.id("personal_txtEmployeeId");
	private final By calendar_licenseExpiryDate = By.id("personal_txtLicExpDate");
	private final By radio_gender_male = By.xpath("//label[text()='Male']");
	private final By radio_gender_female = By.xpath("//label[text()='Female']");
	private final By dropdown_maritial_status = By.id("personal_cmbMarital");
	private final By btn_save = By.id("btnSave");
	
	
	public OrangeHRMHomePage clickWelcome() {
		ExplictWaitFactory.performExplicitWait(link_welcome, WaitStratergy.CLICKABLE).click();
		return this;
	}

	public OrangeHRMLoginPage clicklogout() {
		ExplictWaitFactory.performExplicitWait(link_logout, WaitStratergy.CLICKABLE).click();
		return new OrangeHRMLoginPage();
	}
	
	public OrangeHRMHomePage clickOnMyInfoTab() {
		ExplictWaitFactory.performExplicitWait(link_myInfo, WaitStratergy.CLICKABLE).click();
		return this;
	}
	
	public OrangeHRMHomePage clickOnEditMyInfoTab() {
		ExplictWaitFactory.performExplicitWait(btn_edit, WaitStratergy.CLICKABLE).click();
		return this;
	}
	
	public OrangeHRMHomePage enterFirstName(String firstName) {
		ExplictWaitFactory.performExplicitWait(txt_firstName, WaitStratergy.CLICKABLE).clear();
		ExplictWaitFactory.performExplicitWait(txt_firstName, WaitStratergy.CLICKABLE).sendKeys(firstName);
		return this;
	}
	
	public OrangeHRMHomePage enterMiddleName(String middleName) {
		ExplictWaitFactory.performExplicitWait(txt_middleName, WaitStratergy.CLICKABLE).clear();
		ExplictWaitFactory.performExplicitWait(txt_middleName, WaitStratergy.CLICKABLE).sendKeys(middleName);
		return this;
	}
	
	public OrangeHRMHomePage enterLastName(String lastName) {
		ExplictWaitFactory.performExplicitWait(txt_lastName, WaitStratergy.CLICKABLE).clear();
		ExplictWaitFactory.performExplicitWait(txt_lastName, WaitStratergy.CLICKABLE).sendKeys(lastName);
		return this;
	}
	
	public OrangeHRMHomePage enterEmployeeId(String employeeId) {
		ExplictWaitFactory.performExplicitWait(txt_employeeId, WaitStratergy.CLICKABLE).clear();
		ExplictWaitFactory.performExplicitWait(txt_employeeId, WaitStratergy.CLICKABLE).sendKeys(employeeId);
		return this;
	}
	
	public OrangeHRMHomePage enterLicenseExpiryDate(String licenseExpiryDate) {
		ExplictWaitFactory.performExplicitWait(calendar_licenseExpiryDate, WaitStratergy.CLICKABLE).clear();
		ExplictWaitFactory.performExplicitWait(calendar_licenseExpiryDate, WaitStratergy.CLICKABLE).sendKeys(licenseExpiryDate);
		return this;
	}
	public OrangeHRMHomePage selectGender(String gender) {
		if(gender.equalsIgnoreCase("male")) {
			ExplictWaitFactory.performExplicitWait(radio_gender_male, WaitStratergy.CLICKABLE).click();
		}
		else {
			ExplictWaitFactory.performExplicitWait(radio_gender_female, WaitStratergy.CLICKABLE).click();
		}
		return this;
	}
	
	public OrangeHRMHomePage selectMaritalStatus(String status) throws Exception {
		
		Select select = new Select(ExplictWaitFactory.performExplicitWait(dropdown_maritial_status,WaitStratergy.VISIBLE));
		
		if(status.equalsIgnoreCase("Single")) {
			select.selectByVisibleText(status);
		}
		else if(status.equalsIgnoreCase("Married")) {
			select.selectByVisibleText(status);
		}
		else if(status.equalsIgnoreCase("Other")) {
			select.selectByVisibleText(status);
		}
		else {
			throw new Exception("");
		}
		return this;
	}
	
	public OrangeHRMHomePage clickOnSaveBtnMyInfoTab() {
		ExplictWaitFactory.performExplicitWait(btn_save, WaitStratergy.CLICKABLE).click();
		return this;
	}
}
