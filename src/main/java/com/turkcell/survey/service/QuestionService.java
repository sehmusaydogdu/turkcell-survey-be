package com.turkcell.survey.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.survey.authentication.model.response.UserOutput;
import com.turkcell.survey.exception.DataNotFoundException;
import com.turkcell.survey.exception.UserAlreadyAnsweredException;
import com.turkcell.survey.model.Question;
import com.turkcell.survey.model.QuestionsAnswered;
import com.turkcell.survey.model.request.SurveyAnswerInput;
import com.turkcell.survey.repository.IQuestionRepository;
import com.turkcell.survey.repository.IQuestionsAnsweredRepository;
import com.turkcell.survey.util.PropertyKeys;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuestionService implements IQuestionService {

	@Autowired
	private HttpSession session;

	@Autowired
	private PropertyKeys propertyKeys;

	@Autowired
	private IQuestionRepository repository;

	@Autowired
	private IQuestionsAnsweredRepository answered;

	@Override
	public List<Question> retrieveAll() {
		return repository.findAll();
	}

	@Override
	public Question saveQuestion(String questionText) {
		Question question = new Question();
		question.setQuestionText(questionText);
		Question model = repository.save(question);
		log.info("Question is created.");
		return model;
	}

	@Override
	public Question findByQuestionId(Long questionId) throws DataNotFoundException {
		Optional<Question> question = repository.findById(questionId);
		if (question.isEmpty()) {
			throw new DataNotFoundException("Kayıt bulunamadı.");
		}
		return question.get();
	}

	@Override
	public Question deleteQuestion(Long questionId) throws DataNotFoundException {
		Question model = findByQuestionId(questionId);
		repository.deleteById(questionId);
		log.info("Question is deleted.");
		return model;
	}

	@Override
	public void saveUserAnswered(SurveyAnswerInput input) throws UserAlreadyAnsweredException {
		UserOutput userOutput = (UserOutput) session.getAttribute(propertyKeys.getUserSession());

		Long userId = userOutput.getUserId();
		Long questionId = input.getQuestionId();
		Long answerId = input.getAnswerId();

		Optional<QuestionsAnswered> user = answered.findByUserIdAndQuestionId(userId, questionId);
		if (!user.isEmpty()) {
			throw new UserAlreadyAnsweredException("Kullanıcı bu soruyu daha önceden cevaplamıştır.");
		}
		QuestionsAnswered model = new QuestionsAnswered();
		model.setUserId(userId);
		model.setAnswerId(answerId);
		model.setQuestionId(questionId);
		model.setAnsweredDate(new Date());

		answered.save(model);

		log.info("Answered database inserted.");
	}

	@Override
	public void updateQuestion(Long currentQuestionId, String newQuestionText) throws DataNotFoundException {
		Question currentModel = findByQuestionId(currentQuestionId);
		currentModel.setQuestionText(newQuestionText);
		repository.save(currentModel);
		log.info("Question is updated.");
	}
}
