package com.webautomation.exceptions;

/**
 * <b>Info</b><br>
 * <b>Date</b> - Mar 9, 2022 <br>
 * <b>Time</b> - 3:43:09 PM <br>
 * <b>Project Name</b> - WebAutomationFramework <br>
 * <b>Package Name</b> - com.webautomation.exceptions <br>
 * 
 * <Pre>
 * User defined Exception - PropertyFileUsageException occurred while Reading data from Property File 
 * This Exception is a Run-time Exception and Execution occurs when it is thrown
 * </Pre>
 * 
 * @author Rakesh Jogula <p>
 * @version 1.0 <p>
 */
public class PropertyFileUsageException extends FrameworkException {


	private static final long serialVersionUID = 1L;

	public PropertyFileUsageException(String message) {
		super(message);
	}
	
	public PropertyFileUsageException(String message, Throwable cause) {
		super(message,cause);
	}

}
