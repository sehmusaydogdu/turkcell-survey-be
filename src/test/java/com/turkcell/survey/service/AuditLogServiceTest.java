package com.turkcell.survey.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.turkcell.survey.model.AuditLog;
import com.turkcell.survey.repository.IAuditLogRepository;
import com.turkcell.survey.util.Utils;

@SpringBootTest
class AuditLogServiceTest {

	@InjectMocks
	private AuditLogService service;

	@Mock
	private IAuditLogRepository repository;

	@Test
	void testSaveAuditLog() {
		AuditLog model = Utils.createAuditModel();
		service.saveAuditLog(model);
		Mockito.when(repository.findAll()).thenReturn(List.of(model));
		assertThat(repository.findAll().size()).isEqualTo(1);
	}
}
