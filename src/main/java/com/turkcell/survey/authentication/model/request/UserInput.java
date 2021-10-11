package com.turkcell.survey.authentication.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Keeping username and password client information.
 * 
 * @author Şeyhmus Aydoğdu
 *
 */

@Getter
@Setter
@Builder
public class UserInput {

	String username;
	String password;
}
