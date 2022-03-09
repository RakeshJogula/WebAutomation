package com.webautomation.constants;

import com.webautomation.enums.ConfigProperties;
import com.webautomation.utils.PropertyUtils;

/**
 * <b>Info</b><br>
 * <b>Date</b> - Mar 9, 2022 <br>
 * <b>Time</b> - 2:01:03 PM <br>
 * <b>Project Name</b> - WebAutomationFramework <br>
 * <b>Package Name</b> - com.webautomation.constants <p>
 * FrameworkConstant -has all framework related constants<p>
 * <b>Note</b> - <br>
 * 1. In order to create new fields provide field with private access and
 * access it using public getter methods<br>
 * 2. Class is declared as Final in order to avoid extending this class to other
 * class<br>
 * 3. Constructor is declared as Private to avoid creating a new object<br>
 * 
 * @author Rakesh Jogula <br>
 * @version 1.0 <br>
 * 
 * 
 */
public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCEPATH + "/executables/chromedriver.exe";
	private static final String CONFIGPATH = RESOURCEPATH + "/config/config.properties";
	private static final String EXCELPATH = RESOURCEPATH + "/excel/TestData.xlsx";
	private static final String JSONPATH = RESOURCEPATH + "/json/testdata.json";
	private static final String REPORTPATHFOLDER = System.getProperty("user.dir") + "/extent-test-output/";
	private static String extentReportPath = "";

	/**
	 * get chromedriver.exe path
	 * 
	 * @return - String ChromedriverPath
	 */
	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}

	/**
	 * get config file path
	 * 
	 * @return - String ConfigFilePath
	 */
	public static String getConfigpath() {
		return CONFIGPATH;
	}

	/**
	 * get excel path
	 * 
	 * @return - String ExcelPath
	 */
	public static String getExcelpath() {
		return EXCELPATH;
	}

	/**
	 * get Json path
	 * 
	 * @return - String JsonPath
	 */
	public static String getJsonpath() {
		return JSONPATH;
	}

	/**
	 * get test report path <br>
	 * Uses -- "overridereports" from config file <br>
	 * if yes, report will have name as name+Timestamp <br>
	 * if no, report will have only name <br>
	 * 
	 * @return - String ReportPath
	 */
	public static String getReportpath() {
		if (extentReportPath.equals("")) {
			if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
				extentReportPath = REPORTPATHFOLDER + System.currentTimeMillis() + "_index.html";
				return extentReportPath;
			} else {
				return extentReportPath;
			}
		} else {
			return extentReportPath;
		}
	}

}
