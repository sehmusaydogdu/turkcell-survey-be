package com.turkcell.survey.service;

import java.util.List;

import com.turkcell.survey.exception.DataNotFoundException;
import com.turkcell.survey.exception.UserAlreadyAnsweredException;
import com.turkcell.survey.model.Question;
import com.turkcell.survey.model.request.SurveyAnswerInput;

/**
 * Question service interface definition.
 * 
 * @author Şeyhmus Aydoğdu
 *
 */
public interface IQuestionService {

	/**
	 * Return all answers.
	 * 
	 * @return list of questions.
	 */
	List<Question> retrieveAll();

	/**
	 * Used to record questions.
	 * 
	 * @param questionText
	 * @return Returns the saved question.
	 */
	Question saveQuestion(String questionText);

	/**
	 * Finds the question based on the selected id.
	 * 
	 * @param questionId searched question id.
	 * @return Returns the found question.
	 * @throws DataNotFoundException if question is null then throw exception.
	 */
	Question findByQuestionId(Long questionId) throws DataNotFoundException;

	/**
	 * 
	 * @param questionId of the question to be deleted.
	 * @return the deleted question.
	 * @throws DataNotFoundException if question is null then throw exception
	 */
	Question deleteQuestion(Long questionId) throws DataNotFoundException;

	/**
	 * Records the user is response.
	 * 
	 * @param input user is answer.
	 * @throws UserAlreadyAnsweredException if user answered then throw exception.
	 */
	void saveUserAnswered(SurveyAnswerInput input) throws UserAlreadyAnsweredException;

	/**
	 * Used to update the question.
	 * 
	 * @param currentQuestionId current question id.
	 * @param newQuestionText   new question info.
	 * @throws DataNotFoundException if current question is null then throw
	 *                               exception.
	 */
	void updateQuestion(Long currentQuestionId, String newQuestionText) throws DataNotFoundException;
}
