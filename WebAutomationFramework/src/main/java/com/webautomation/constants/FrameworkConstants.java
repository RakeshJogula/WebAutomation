package com.webautomation.constants;

import com.webautomation.enums.ConfigProperties;
import com.webautomation.utils.PropertyUtils;

/**
 * @author Admin
 *  Made Class as Final in order to avoid extending this class to other class
 *  Created private constructor to avoid creating a new object
 */
public final class FrameworkConstants {

	
	private FrameworkConstants() {
		
	}
	
	private static final String RESOURCEPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCEPATH+"/executables/chromedriver.exe";
	private static final String CONFIGPATH = RESOURCEPATH+"/config/config.properties";
	private static final String EXCELPATH = RESOURCEPATH+"/excel/TestData.xlsx";
	private static final String JSONPATH = RESOURCEPATH+"/json/testdata.json";
	private static final String REPORTPATHFOLDER = System.getProperty("user.dir")+"/extent-test-output/";
	private static String extentReportPath = "";
	
	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}

	public static String getConfigpath() {
		return CONFIGPATH;
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}

	public static String getJsonpath() {
		return JSONPATH;
	}

	public static String getReportpath() throws Exception {
		if(extentReportPath.equals("")) {
			if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
				extentReportPath = REPORTPATHFOLDER + System.currentTimeMillis() + "_index.html";
				return extentReportPath;
			} else {
				return extentReportPath;
			}
		}else {
			return extentReportPath;
		}		
	}
	
}
