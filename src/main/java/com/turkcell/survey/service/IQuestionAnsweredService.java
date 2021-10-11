package com.turkcell.survey.service;

import java.util.List;

import com.turkcell.survey.model.QuestionsAnswered;

/**
 * Question answered service interface definition.
 * 
 * @author Şeyhmus Aydoğdu
 *
 */
public interface IQuestionAnsweredService {

	/**
	 * 
	 * @return list of questions answered.
	 */
	List<QuestionsAnswered> retrieveAll();
}
