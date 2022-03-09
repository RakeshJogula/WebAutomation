package com.webautomation.tests;

import java.util.HashMap;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.webautomation.annotations.FrameworkAnnotations;
import com.webautomation.dataprovider.ExcelDataProvider;
import com.webautomation.enums.Authors;
import com.webautomation.enums.Category;
import com.webautomation.listeners.RetryFailedTest;
import com.webautomation.pages.OrangeHRMLoginPage;

public final class OrangeHRMTests extends BaseTests{
	
	private OrangeHRMTests() {
		
	}
	
	@FrameworkAnnotations(category = Category.SANITY,author = Authors.ADMIN)
	@Test(dataProvider = "testdata",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = RetryFailedTest.class)
	public void loginlogutTest(HashMap<String,String> data) {
		String title =  new OrangeHRMLoginPage()
				.enterUsername(data.get("Username"))
				.enterPassword(data.get("Password"))
				.clickLoginBtn().clickWelcome()
				.clicklogout()
				.getTitle();
		Assertions.assertThat(title).isEqualTo("OrangeHRM");
	}
	
	@FrameworkAnnotations(category = Category.SMOKE,author = Authors.QA1)
	@Test(dataProvider = "testdata",dataProviderClass = ExcelDataProvider.class,retryAnalyzer = RetryFailedTest.class)
	public void MyInfoTest(HashMap<String,String> data) throws Exception {
		new OrangeHRMLoginPage()
		.enterUsername(data.get("Username"))
		.enterPassword(data.get("Password"))
		.clickLoginBtn()
		.clickOnMyInfoTab()
		.clickOnEditMyInfoTab()
		.enterFirstName(data.get("First Name"))
		.enterLastName(data.get("Last Name"))
		.enterMiddleName(data.get("Middle Name"))
		.enterEmployeeId(data.get("Employee Id"))
		.enterLicenseExpiryDate(data.get("License Expiry Date"))
		.selectGender(data.get("Gender"))
		.selectMaritalStatus(data.get("Marital Status"))
		.clickOnSaveBtnMyInfoTab();
	}
	

}
