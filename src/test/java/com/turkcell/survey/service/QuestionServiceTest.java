package com.turkcell.survey.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.turkcell.survey.model.Question;
import com.turkcell.survey.repository.IQuestionRepository;
import com.turkcell.survey.util.Utils;

@SpringBootTest
class QuestionServiceTest {

	@InjectMocks
	private QuestionService service;

	@Mock
	private IQuestionRepository repository;

	@Test
	void testRetrieveAll() {
		Question model = Utils.createQuestion();
		List<Question> list = List.of(model);

		Mockito.when(repository.findAll()).thenReturn(list);
		assertThat(service.retrieveAll().size()).isEqualTo(1);
	}
}
