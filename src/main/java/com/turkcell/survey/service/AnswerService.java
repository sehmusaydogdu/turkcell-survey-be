package com.turkcell.survey.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.survey.exception.DataNotFoundException;
import com.turkcell.survey.model.Answer;
import com.turkcell.survey.model.Question;
import com.turkcell.survey.repository.IAnswerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AnswerService implements IAnswerService {

	@Autowired
	private IAnswerRepository repository;

	@Autowired
	private QuestionService questionService;

	@Override
	public List<Answer> retrieveAll() {
		return repository.findAll();
	}

	@Override
	public Answer saveAnswer(Long questionId, String answerText) throws DataNotFoundException {

		Answer answer = new Answer();
		answer.setQuestionId(questionId);
		answer.setAnswerText(answerText);

		Question question = questionService.findByQuestionId(questionId);
		answer.setQuestion(question);

		Answer model = repository.save(answer);

		log.info("Answer is created.");

		return model;
	}

	@Override
	public Answer deleteAnswer(Long answerId) throws DataNotFoundException {
		Answer model = searchAnswer(answerId);
		repository.deleteById(answerId);
		return model;
	}

	private Answer searchAnswer(Long answerId) throws DataNotFoundException {
		Optional<Answer> answer = repository.findById(answerId);
		if (answer.isEmpty()) {
			throw new DataNotFoundException("Silmek istediğiniz kayıt bulunamadı.");
		}
		return answer.get();
	}
}
