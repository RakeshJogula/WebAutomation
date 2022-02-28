package com.webautomation.constants;

/**
 * @author Admin
 *  Made Class as Final in order to avoid extending this class to other class
 *  Created private constructor to avoid creating a new object
 */
public final class FrameworkConstants {

	
	private FrameworkConstants() {
		
	}
	
	private static final String CHROMEDRIVERPATH = System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver.exe";

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}
	
}
