package com.turkcell.survey.authentication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Keeps user information details.
 * 
 * @author Şeyhmus Aydoğdu
 *
 */

@Entity
@Getter
@Setter
@Table(name = "USER_INFO")
public class UserInfo {

	@Id
	@Column(name = "USER_ID", nullable = false, unique = true)
	Long userId;

	@Column(name = "NAME", nullable = false)
	String name;

	@Column(name = "SURNAME", nullable = false)
	String surname;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "USER_TYPE", nullable = false)
	UserType userType;
}
