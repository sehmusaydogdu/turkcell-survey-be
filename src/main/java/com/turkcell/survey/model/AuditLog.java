package com.turkcell.survey.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * User system trace monitoring info
 * 
 * @author Şeyhmus Aydoğdu
 *
 */
@Entity
@Getter
@Setter
@Table(name = "AUDIT_LOG")
public class AuditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUDIT_TABLE_SEQUENCE")
	@SequenceGenerator(name = "AUDIT_TABLE_SEQUENCE", allocationSize = 1)
	@Column(name = "AUDIT_ID")
	private Long auditId;

	@Column(name = "USER_ID", nullable = false)
	private Long userId;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "LOGIN_DATE", nullable = false)
	private Date loginDate;
}
