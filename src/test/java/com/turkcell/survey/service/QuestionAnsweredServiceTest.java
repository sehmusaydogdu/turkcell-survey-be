package com.turkcell.survey.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.turkcell.survey.model.QuestionsAnswered;
import com.turkcell.survey.repository.IQuestionsAnsweredRepository;
import com.turkcell.survey.util.Utils;

@SpringBootTest
class QuestionAnsweredServiceTest {

	@InjectMocks
	private QuestionAnsweredService service;

	@Mock
	private IQuestionsAnsweredRepository repository;

	@Test
	void testRetrieveAll() {
		QuestionsAnswered model = Utils.createQuestionsAnswered();
		List<QuestionsAnswered> list = List.of(model);

		Mockito.when(repository.findAll()).thenReturn(list);
		assertThat(service.retrieveAll().size()).isEqualTo(1);
	}

}
