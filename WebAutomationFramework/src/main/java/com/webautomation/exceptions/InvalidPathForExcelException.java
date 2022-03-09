package com.webautomation.exceptions;

/**
 * <b>Info</b><br>
 * <b>Date</b> - Mar 9, 2022 <br>
 * <b>Time</b> - 3:41:23 PM <br>
 * <b>Project Name</b> - WebAutomationFramework <br>
 * <b>Package Name</b> - com.webautomation.exceptions <br>
 * 
 * 	<Pre>
 *  User defined Exception - Invalid Path for Excel Exception it is a Run-time Exception and Execution occurs when it is thrown 
 *  </Pre> 
 * 
 * @author Rakesh Jogula <p>
 * @version 1.0 <p>
 */
public class InvalidPathForExcelException extends FrameworkException {


	private static final long serialVersionUID = 1L;
	public InvalidPathForExcelException(String message) {
		super(message);
	}
	public InvalidPathForExcelException(String message,Throwable clause) {
		super(message,clause);
	}

}
