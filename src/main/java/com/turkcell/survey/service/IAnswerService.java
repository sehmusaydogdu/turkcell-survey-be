package com.turkcell.survey.service;

import java.util.List;

import com.turkcell.survey.exception.DataNotFoundException;
import com.turkcell.survey.model.Answer;

/**
 * Answer service interface definition.
 * 
 * @author Şeyhmus Aydoğdu
 *
 */
public interface IAnswerService {

	/**
	 * Used to record questions.
	 * 
	 * @param questionId of the selected question.
	 * @param answerText answer is text.
	 * @return Returns the saved answer.
	 * @throws DataNotFoundException if answer is null then throw exception.
	 */
	Answer saveAnswer(Long questionId, String answerText) throws DataNotFoundException;

	/**
	 * It used to delete answer.
	 * 
	 * @param answerId of the answer to be deleted.
	 * @return the deleted answer.
	 * @throws DataNotFoundException if answer is null then throw exception.
	 */
	Answer deleteAnswer(Long answerId) throws DataNotFoundException;

	/**
	 * Retrieve all answers
	 * 
	 * @return list of answers
	 */
	List<Answer> retrieveAll();
}
