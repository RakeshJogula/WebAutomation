package com.webautomation.constants;

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
	
	
	
	
	
}
