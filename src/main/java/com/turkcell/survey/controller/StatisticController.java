package com.turkcell.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.turkcell.survey.aspect.EnableSecurity;
import com.turkcell.survey.model.Statistics;
import com.turkcell.survey.model.response.ApiResponse;
import com.turkcell.survey.service.StatisticService;

@RestController
@RequestMapping("/api")
public class StatisticController {

	@Autowired
	private StatisticService service;

	@GetMapping("/statistic/{questionId}")
	@EnableSecurity
	public ApiResponse<Statistics> retrieveStatistics(@PathVariable("questionId") Long questionId) {
		try {
			ApiResponse<Statistics> response = new ApiResponse<>();
			response.setData(service.getStatistics(questionId));
			response.setMessage("OK");
			response.setStatus(true);
			return response;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
