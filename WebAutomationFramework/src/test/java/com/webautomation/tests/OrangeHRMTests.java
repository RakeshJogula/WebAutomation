package com.webautomation.tests;

import java.util.HashMap;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.webautomation.dataprovider.ExcelDataProvider;
import com.webautomation.dataprovider.JSONDataProvider;
import com.webautomation.pages.OrangeHRMLoginPage;

public final class OrangeHRMTests extends BaseTests{
	
	private OrangeHRMTests() {
		
	}
	
	//@Test(dataProvider = "jsondata",dataProviderClass = JSONDataProvider.class)
	public void loginlogutTest(HashMap<String,Object> data) {
		String title =  new OrangeHRMLoginPage()
				.enterUsername(data.get("username").toString())
				.enterPassword(data.get("password").toString())
				.clickLoginBtn().clickWelcome()
				.clicklogout()
				.getTitle();
		Assertions.assertThat(title).isEqualTo("OrangeHRM");
	}
	
	
	@Test(dataProvider = "testdata",dataProviderClass = ExcelDataProvider.class)
	public void MyInfoTest(HashMap<String,String> data) throws Exception {
		new OrangeHRMLoginPage()
		.enterUsername("Admin")
		.enterPassword("admin123")
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
