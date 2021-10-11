package com.turkcell.survey.exception;

/**
 * Used when the user's password is incorrect.
 * 
 * @author Şeyhmus Aydoğdu
 *
 */
public class WrondUserCredentialException extends Exception {

	/**
	 * serial number
	 */
	private static final long serialVersionUID = 1L;

	public WrondUserCredentialException(String msg) {
		super(msg);
	}

}