package com.turkcell.survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.survey.model.QuestionsAnswered;
import com.turkcell.survey.repository.IQuestionsAnsweredRepository;

@Service
public class QuestionAnsweredService implements IQuestionAnsweredService {

	@Autowired
	private IQuestionsAnsweredRepository repository;

	@Override
	public List<QuestionsAnswered> retrieveAll() {
		return repository.findAll();
	}
}
