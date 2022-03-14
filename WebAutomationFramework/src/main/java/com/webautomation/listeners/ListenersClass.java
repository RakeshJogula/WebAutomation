package com.webautomation.listeners;


import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.webautomation.annotations.FrameworkAnnotations;
import com.webautomation.reports.ExtentLogger;
import com.webautomation.reports.ExtentReport;
import com.webautomation.utils.ELKUtils;

public class ListenersClass implements ITestListener, ISuiteListener {

	public void onStart(ISuite suite) {
			ExtentReport.initExtentReport();
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
		ExtentReport.assignAuthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author());
		ExtentReport.addCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category());
	}

	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + "is passed");
		ELKUtils.sendDetailsToELK(result.getMethod().getMethodName(), "pass");
	}

	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName() + "is failed");
		ExtentLogger.fail(result.getThrowable().getMessage());
		ELKUtils.sendDetailsToELK(result.getMethod().getMethodName(), "fail");
	}

	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + "is skipped");
		ELKUtils.sendDetailsToELK(result.getMethod().getMethodName(), "skip");
	}

}
