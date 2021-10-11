package com.turkcell.survey.service;

import com.turkcell.survey.model.AuditLog;

/**
 * Audit log service interface definition.
 * 
 * @author Şeyhmus Aydoğdu
 */
public interface IAuditLogService {

	/**
	 * Keeps login information of users.
	 * 
	 * @param model Audit model is definition info
	 */
	void saveAuditLog(AuditLog model);
}
