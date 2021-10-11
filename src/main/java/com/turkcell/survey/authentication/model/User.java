package com.turkcell.survey.authentication.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Keeps username and password information.
 * 
 * @author Şeyhmus Aydoğdu
 *
 */
@Entity
@Getter
@Setter
@Table(name = "USERS")
public class User {

	@Id
	@Column(name = "USER_ID", nullable = false, unique = true)
	private Long userId;

	@Column(name = "USER_NAME", nullable = false, unique = true)
	private String userName;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private UserInfo userInfo;
}
