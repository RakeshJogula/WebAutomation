package com.webautomation.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.webautomation.utils.ExcelUtils;

/**
 * @author Admin
 *  IMethodInterceptor - This class is used to alter the list of test methods that TestNG is about to run. 
 *  An instance of this class will be invoked right before TestNG starts invoking test methods
 *
 */
public class MethodInterceptor implements IMethodInterceptor{

	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		List<HashMap<String, String>> list = ExcelUtils.getTestDetails("RunManager");
		List<IMethodInstance> testsNeedtoBeExecuted = new ArrayList<IMethodInstance>();

		for (int i = 0; i < methods.size(); i++) {
			for (int i1 = 0; i1 < list.size(); i1++) {
				if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(i1).get("TestCaseName"))) {
					if (list.get(i1).get("Execute").equalsIgnoreCase("Yes")) {
						methods.get(i).getMethod().setDescription(list.get(i1).get("TestCaseDescription"));
						testsNeedtoBeExecuted.add(methods.get(i));
					}
				}
			}
		}
		return testsNeedtoBeExecuted;
	}
}
