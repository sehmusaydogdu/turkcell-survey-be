package com.turkcell.survey.authentication.model.response;

import java.io.Serializable;

import com.turkcell.survey.authentication.model.UserType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Keeping user client information.
 * 
 * @author Şeyhmus Aydoğdu
 *
 */

@Getter
@Setter
@Builder
public class UserOutput implements Serializable {

	/**
	 * serial number
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;
	private String name;
	private UserType userType;
}
