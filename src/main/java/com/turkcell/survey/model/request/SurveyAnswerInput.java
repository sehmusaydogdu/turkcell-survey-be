package com.turkcell.survey.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurveyAnswerInput {
	private Long questionId;
	private Long answerId;
}
