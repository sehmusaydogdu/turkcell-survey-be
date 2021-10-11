package com.turkcell.survey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.survey.model.AuditLog;
import com.turkcell.survey.repository.IAuditLogRepository;

@Service
public class AuditLogService implements IAuditLogService {

	@Autowired
	private IAuditLogRepository repository;

	@Override
	public void saveAuditLog(AuditLog model) {
		repository.save(model);
	}
}
