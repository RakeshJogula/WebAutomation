package com.webautomation.listeners;


import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.webautomation.reports.ExtentLogger;
import com.webautomation.reports.ExtentReport;

public class ListenersClass implements ITestListener, ISuiteListener {

	public void onStart(ISuite suite) {
		try {
			ExtentReport.initExtentReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onFinish(ISuite suite) {
			try {
				ExtentReport.flushReport();
			} catch (Exception e) {
				e.printStackTrace();
			}		
	}

	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + "is passed");
	}

	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName() + "is failed");
		ExtentLogger.fail(result.getThrowable().getMessage());
	}

	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + "is skipped");
	}

}
