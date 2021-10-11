package com.turkcell.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.turkcell.survey.aspect.EnableSecurity;
import com.turkcell.survey.model.Answer;
import com.turkcell.survey.model.request.RequestInput;
import com.turkcell.survey.model.response.ApiResponse;
import com.turkcell.survey.service.IAnswerService;

@RestController
@RequestMapping("/api")
public class AnswerController {

	@Autowired
	private IAnswerService service;

	@GetMapping("/answer/all")
	public ResponseEntity<List<Answer>> retrieveAll() {
		try {
			return ResponseEntity.ok(service.retrieveAll());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@EnableSecurity
	@PostMapping("/answer/create")
	public ApiResponse<Answer> createQuestion(@RequestBody RequestInput input) {
		try {
			String answerText = input.getText();
			Long questionId = input.getQuestionId();

			Assert.notNull(answerText, "Cevap seçeneği boş geçilemez.");
			Assert.notNull(questionId, "Soru geçimi yapmanız gerekmektedir.");

			Answer model = service.saveAnswer(questionId, answerText);

			ApiResponse<Answer> response = new ApiResponse<>();
			response.setMessage("Kayıt ekleme başarılı.");
			response.setStatus(true);
			response.setData(model);
			return response;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@EnableSecurity
	@DeleteMapping("/answer/delete/{answerId}")
	public ApiResponse<Answer> delete(@PathVariable("answerId") Long answerId) {
		try {
			Answer model = service.deleteAnswer(answerId);

			ApiResponse<Answer> response = new ApiResponse<>();
			response.setMessage("Kayıt silme başarılı.");
			response.setStatus(true);
			response.setData(model);
			return response;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
