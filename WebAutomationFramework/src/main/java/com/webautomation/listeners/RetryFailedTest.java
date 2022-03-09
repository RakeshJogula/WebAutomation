package com.webautomation.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.webautomation.enums.ConfigProperties;
import com.webautomation.utils.PropertyUtils;

public class RetryFailedTest implements IRetryAnalyzer{

	private int count = 0 ;
	private int limit = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTEST).equalsIgnoreCase("Yes")) {
			if(count<limit) {
				count++;
				return true;
			}
		}		
			return false;
	}

}
