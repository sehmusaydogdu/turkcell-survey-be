package com.turkcell.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.turkcell.survey.aspect.EnableSecurity;
import com.turkcell.survey.model.QuestionsAnswered;
import com.turkcell.survey.model.response.ApiResponse;
import com.turkcell.survey.service.IQuestionAnsweredService;

@RestController
@RequestMapping("/api")
public class QuestionAnsweredController {

	@Autowired
	private IQuestionAnsweredService service;

	@EnableSecurity
	@GetMapping("/questionAnswered/all")
	public ApiResponse<List<QuestionsAnswered>> retrieveAll() {
		try {
			ApiResponse<List<QuestionsAnswered>> response = new ApiResponse<>();
			response.setStatus(true);
			response.setData(service.retrieveAll());
			response.setMessage("OK");

			return response;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
