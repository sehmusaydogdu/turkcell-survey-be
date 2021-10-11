package com.turkcell.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.survey.model.AuditLog;

public interface IAuditLogRepository extends JpaRepository<AuditLog, Long>{

}
