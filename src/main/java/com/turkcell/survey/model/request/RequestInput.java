package com.turkcell.survey.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestInput {
	private Long questionId;
	private String text;
	private SurveyAnswerInput result;
}
