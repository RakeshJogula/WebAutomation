package com.webautomation.utils;

import java.io.*;
import java.util.*;

import com.webautomation.constants.FrameworkConstants;
import com.webautomation.enums.ConfigProperties;

/**
 * @author Admin
 *	To Read Property File
 * 	using Static block to do early initialization of property file and loading it
 *  Use HashMap when ever you have more feilds in config file
 */
public class PropertyUtils {

	private PropertyUtils() {

	}
	
	private static Properties property = new Properties();
	private static final Map<String,String> CONFIGMAP = new HashMap<String,String>();
	
	static {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(FrameworkConstants.getConfigpath()); 
			property.load(fileInputStream);
			
			for (String key: property.stringPropertyNames()) {
				CONFIGMAP.put(key, property.getProperty(key));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static String get(ConfigProperties key) throws Exception {
		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property Name "+key+"is not found please check config properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
	
}
