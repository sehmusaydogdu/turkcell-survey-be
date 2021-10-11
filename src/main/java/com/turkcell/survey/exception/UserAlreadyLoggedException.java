package com.turkcell.survey.exception;

/**
 * If User is already logged in throw exception.
 * 
 * @author Şeyhmus Aydoğdu
 *
 */
public class UserAlreadyLoggedException extends Exception {

	/**
	 * serial number
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyLoggedException(String msg) {
		super(msg);
	}
}