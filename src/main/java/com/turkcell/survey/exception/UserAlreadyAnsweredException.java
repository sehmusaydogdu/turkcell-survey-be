package com.turkcell.survey.exception;

/**
 * if user already replied then throw exception
 * 
 * @author Şeyhmus Aydoğdu
 *
 */
public class UserAlreadyAnsweredException extends Exception {

	/**
	 * serial number
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyAnsweredException(String msg) {
		super(msg);
	}
}
