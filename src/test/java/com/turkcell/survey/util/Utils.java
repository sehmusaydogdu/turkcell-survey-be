package com.turkcell.survey.util;

import java.util.Date;

import com.turkcell.survey.model.Answer;
import com.turkcell.survey.model.AuditLog;
import com.turkcell.survey.model.Question;
import com.turkcell.survey.model.QuestionsAnswered;

public class Utils {

	public static Answer createAnswer() {
		Answer model = new Answer();
		model.setAnswerId(1L);
		model.setAnswerText("Evet");
		return model;
	}

	public static Question createQuestion() {
		Question model = new Question();
		model.setQuestionId(1L);
		model.setQuestionText("Yöneticinden memnun musun?");
		return model;
	}

	public static QuestionsAnswered createQuestionsAnswered() {
		QuestionsAnswered model = new QuestionsAnswered();
		model.setId(1L);
		model.setAnsweredDate(new Date());
		model.setAnswerId(1L);
		model.setQuestionId(1L);
		model.setUserId(1L);
		return model;
	}

	public static AuditLog createAuditModel() {	
		AuditLog model = new AuditLog();
		model.setAuditId(1L);
		model.setLoginDate(new Date());
		model.setName("Ali");
		model.setUserId(1L);
		return model;
	}
}
