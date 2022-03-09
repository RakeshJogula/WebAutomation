package com.webautomation.reports;

import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.webautomation.constants.FrameworkConstants;
import com.webautomation.enums.Authors;
import com.webautomation.enums.Category;

/**
 * 
 * Mar 9, 2022
 * 1:09:27 PM
 * WebAutomationFramework
 * com.webautomation.reports
 * @author Rakesh Jogula
 * @version 1.0
 */

public final class ExtentReport {
	
	/**
	 * 
	 */
	private ExtentReport() {
		
	}
	private static ExtentReports extent ;
	
	
	public static void initExtentReport(){		
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(new File(FrameworkConstants.getReportpath()));
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Web Automation Test Report");			
		}
	}
	
	public static void flushReport() throws Exception {
		if(Objects.nonNull(extent)){
			extent.flush();
		}
		ExtentManager.removeCurrentReport();
		Desktop.getDesktop().browse(new File(FrameworkConstants.getReportpath()).toURI());
	}
	
	public static void createTest(String testcaseName) {
		ExtentManager.setExtentTest(extent.createTest(testcaseName));
	}
	
	public static void addCategory(Category[] category) {
		for (Category temp : category) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}
	public static void assignAuthor(Authors[] author) {
		for (Authors temp : author) {
			ExtentManager.getExtentTest().assignAuthor(temp.toString());
		}
	}

	

}
