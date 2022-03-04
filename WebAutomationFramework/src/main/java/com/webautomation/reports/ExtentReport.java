package com.webautomation.reports;

import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.webautomation.constants.FrameworkConstants;

public final class ExtentReport {
	
	private ExtentReport() {
		
	}
	private static ExtentReports extent ;
	
	
	public static void initExtentReport() throws Exception {		
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
		Desktop.getDesktop().browse(new File(FrameworkConstants.getReportpath()).toURI());
	}
	
	public static void createTest(String testcaseName) {
		ExtentManager.setExtentTest(extent.createTest(testcaseName));
	}

}
