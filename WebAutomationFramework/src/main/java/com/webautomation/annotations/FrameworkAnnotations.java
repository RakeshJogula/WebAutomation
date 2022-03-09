package com.webautomation.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.webautomation.enums.Authors;
import com.webautomation.enums.Category;

/**
 * 
 * <b>Info</b> <b>Date</b> - Mar 9, 2022 <br>
 * <b>Time</b> - 2:22:12 PM <br>
 * <b>Project Name</b> - WebAutomationFramework <br>
 * <b>Package Name</b> - com.webautomation.annotations <br>
 * <Pre>FrameworkAnnotations - Is a user defined Annotation for Framework to user at Global level </Pre> <br>
 * <b>About Annotations</b><br>
 * Annotations - To create annotation in java we use @interface and name of
 * annotation <br>
 * Retention - Indicate when these annotations should be called by JVM <br>
 * Target - Indicates What is the Target for these Annotation <br>
 * below class shows - Retention at runtime and it is targeted at method
 * level<br>
 * 
 * @author Rakesh Jogula
 * @version 1.0
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotations {
	public Category[] category() default {};

	public Authors[] author() default {};
}
