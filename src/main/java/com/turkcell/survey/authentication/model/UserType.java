package com.turkcell.survey.authentication.model;

/**
 * Keeps user type informations.
 * 
 * @author Şeyhmus Aydoğdu
 *
 */
public enum UserType {
	ADMIN_USER(0), END_USER(1);

	private final int value;

	private UserType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
