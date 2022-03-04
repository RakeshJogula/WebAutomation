package com.webautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.webautomation.enums.WaitStratergy;
import com.webautomation.factories.ExplictWaitFactory;
import com.webautomation.reports.ExtentLogger;

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
		try {
			click(ExplictWaitFactory.performExplicitWait(link_welcome, WaitStratergy.CLICKABLE));
			ExtentLogger.pass("Click on Link Welcome",true);
		} catch (Exception e) {
			ExtentLogger.fail("Click on Link Welcome",true);
		}
		return this;
	}

	public OrangeHRMLoginPage clicklogout() {
		try {
			click(ExplictWaitFactory.performExplicitWait(link_logout, WaitStratergy.CLICKABLE));
			ExtentLogger.pass("Click on Link Logout",true);
		} catch (Exception e) {
			ExtentLogger.fail("Click on Link Logout",true);
		}
		return new OrangeHRMLoginPage();
	}

	public OrangeHRMHomePage clickOnMyInfoTab() {
		try {
			click(ExplictWaitFactory.performExplicitWait(link_myInfo, WaitStratergy.CLICKABLE));
			ExtentLogger.pass("Click on My Info Tab",true);
		} catch (Exception e) {
			ExtentLogger.fail("Click on My Info Tab",true);
		}
		return this;
	}

	public OrangeHRMHomePage clickOnEditMyInfoTab() {
		try {
			click(ExplictWaitFactory.performExplicitWait(btn_edit, WaitStratergy.CLICKABLE));
			ExtentLogger.pass("Click on Edit Button in My Info Tab",true);
		} catch (Exception e) {
			ExtentLogger.fail("Click on Edit Button in My Info Tab",true);
		}
		return this;
	}

	public OrangeHRMHomePage enterFirstName(String firstName) {
		try {
			sendkeys(ExplictWaitFactory.performExplicitWait(txt_firstName, WaitStratergy.PRESENCE), firstName);
			ExtentLogger.pass("Enter Fisrt Name" + firstName,true);
		} catch (Exception e) {
			ExtentLogger.fail("Enter Fisrt Name" + firstName,true);
		}
		return this;
	}

	public OrangeHRMHomePage enterMiddleName(String middleName) {
		try {
			sendkeys(ExplictWaitFactory.performExplicitWait(txt_middleName, WaitStratergy.PRESENCE), middleName);
			ExtentLogger.pass("Enter Middle Name" + middleName,true);
		} catch (Exception e) {
			ExtentLogger.fail("Enter Middle Name" + middleName,true);
		}
		return this;
	}

	public OrangeHRMHomePage enterLastName(String lastName) {
		try {
			sendkeys(ExplictWaitFactory.performExplicitWait(txt_lastName, WaitStratergy.PRESENCE), lastName);
			ExtentLogger.pass("Enter Last Name" + lastName,true);
		} catch (Exception e) {
			ExtentLogger.fail("Enter Last Name" + lastName,true);
		}
		return this;
	}

	public OrangeHRMHomePage enterEmployeeId(String employeeId) {
		try {
			sendkeys(ExplictWaitFactory.performExplicitWait(txt_employeeId, WaitStratergy.PRESENCE), employeeId);
			ExtentLogger.pass("Enter Employee Id" + employeeId,true);
		} catch (Exception e) {
			ExtentLogger.fail("Enter Employee Id" + employeeId,true);
		}
		return this;
	}

	public OrangeHRMHomePage enterLicenseExpiryDate(String licenseExpiryDate) {
		try {
			sendkeys(ExplictWaitFactory.performExplicitWait(calendar_licenseExpiryDate, WaitStratergy.PRESENCE),
					licenseExpiryDate);
			ExtentLogger.pass("Enter Lisence Expiry Date" + licenseExpiryDate,true);
		} catch (Exception e) {
			ExtentLogger.fail("Enter Lisence Expiry Date" + licenseExpiryDate,true);
		}
		return this;
	}

	public OrangeHRMHomePage selectGender(String gender) {
		try {
			if (gender.equalsIgnoreCase("male")) {
				click(ExplictWaitFactory.performExplicitWait(radio_gender_male, WaitStratergy.CLICKABLE));
			} else {
				click(ExplictWaitFactory.performExplicitWait(radio_gender_female, WaitStratergy.CLICKABLE));
			}
			ExtentLogger.pass("Select Gender" + gender,true);
		} catch (Exception e) {
			ExtentLogger.fail("Select Gender" + gender,true);
		}
		return this;
	}

	public OrangeHRMHomePage selectMaritalStatus(String status) {
		WebElement dropdown_maritialstatus = ExplictWaitFactory.performExplicitWait(dropdown_maritial_status,
				WaitStratergy.VISIBLE);
		selectByVisibleText(dropdown_maritialstatus, status);
		return this;
	}

	public OrangeHRMHomePage clickOnSaveBtnMyInfoTab() {
		try {
			click(ExplictWaitFactory.performExplicitWait(btn_save, WaitStratergy.CLICKABLE));
			ExtentLogger.pass("Click on Save Button in My Info Tab",true);
		} catch (Exception e) {
			ExtentLogger.fail("Click on Save Button in My Info Tab",true);
		}
		return this;
	}
}
