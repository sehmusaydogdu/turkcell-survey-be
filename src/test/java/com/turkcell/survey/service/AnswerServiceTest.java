package com.turkcell.survey.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.turkcell.survey.exception.DataNotFoundException;
import com.turkcell.survey.model.Answer;
import com.turkcell.survey.model.Question;
import com.turkcell.survey.repository.IAnswerRepository;
import com.turkcell.survey.util.Utils;

@SpringBootTest
class AnswerServiceTest {

	@InjectMocks
	private AnswerService service;

	@Mock
	private IAnswerRepository answerRepository;

	@Mock
	private QuestionService questionService;

	@Test
	void testRetrieveAll() {
		Answer model = Utils.createAnswer();
		List<Answer> list = List.of(model);
		Mockito.when(answerRepository.findAll()).thenReturn(list);
		assertThat(service.retrieveAll().size()).isEqualTo(1);
	}

	@Test
	void testSaveAnswer() throws DataNotFoundException {

		Answer answer = Utils.createAnswer();

		Question question = Utils.createQuestion();
		question.setAnswers(Set.of(answer));

		answer.setQuestion(question);

		Mockito.when(questionService.findByQuestionId(Mockito.anyLong())).thenReturn(question);
		Mockito.when(answerRepository.save(Mockito.any())).thenReturn(answer);

		Answer actual = service.saveAnswer(1L, "Evet");

		assertThat(actual.getAnswerId()).isEqualTo(answer.getAnswerId());
		assertThat(actual.getAnswerText()).isEqualTo(answer.getAnswerText());
	}

	@Test
	void testDeleteAnswer() throws DataNotFoundException {

		Answer answer = Utils.createAnswer();

		Question question = Utils.createQuestion();
		question.setAnswers(Set.of(answer));

		answer.setQuestion(question);

		answerRepository.save(answer);
		Mockito.when(answerRepository.findById(1L)).thenReturn(Optional.of(answer));
		Answer actual = service.deleteAnswer(1L);

		assertThat(actual.getAnswerId()).isEqualTo(answer.getAnswerId());
		assertThat(actual.getAnswerText()).isEqualTo(answer.getAnswerText());
	}
}
