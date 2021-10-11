package com.turkcell.survey.exception;

/**
 * if data is null then throw exception
 * 
 * @author Şeyhmus Aydoğdu
 *
 */
public class DataNotFoundException extends Exception {

	/**
	 * serial number
	 */
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String msg) {
		super(msg);
	}
}