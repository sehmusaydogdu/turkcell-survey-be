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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.turkcell.survey.aspect.EnableSecurity;
import com.turkcell.survey.exception.DataNotFoundException;
import com.turkcell.survey.exception.UserAlreadyAnsweredException;
import com.turkcell.survey.model.Question;
import com.turkcell.survey.model.request.RequestInput;
import com.turkcell.survey.model.response.ApiResponse;
import com.turkcell.survey.service.IQuestionService;

@RestController
@RequestMapping("/api")
public class QuestionController {

	@Autowired
	private IQuestionService service;

	@GetMapping("/question/all")
	public ResponseEntity<List<Question>> retrieveAll() {
		try {
			return ResponseEntity.ok(service.retrieveAll());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@EnableSecurity
	@PostMapping("/question/create")
	public ApiResponse<Question> create(@RequestBody RequestInput input) {
		try {
			String questionText = input.getText();
			Assert.notNull(questionText, "Soru alanı boş geçilemez.");

			Question model = service.saveQuestion(questionText);

			ApiResponse<Question> response = new ApiResponse<>();
			response.setMessage("Kayıt ekleme başarılı.");
			response.setStatus(true);
			response.setData(model);
			return response;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@EnableSecurity
	@DeleteMapping("/question/delete/{questionId}")
	public ApiResponse<Question> delete(@PathVariable("questionId") Long questionId) {
		try {
			Question model = service.deleteQuestion(questionId);

			ApiResponse<Question> response = new ApiResponse<>();
			response.setMessage("Kayıt silme başarılı.");
			response.setStatus(true);
			response.setData(model);
			return response;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PostMapping("/questionsAndAnswer")
	public ResponseEntity<String> answerThisquestions(@RequestBody RequestInput input) {
		try {
			service.saveUserAnswered(input.getResult());
			return ResponseEntity.ok("Cevaplar başarılı şekilde kaydedildi.");
		} catch (UserAlreadyAnsweredException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@EnableSecurity
	@PutMapping("/question/update/{questionId}")
	public ApiResponse<String> answerThisquestions(@PathVariable("questionId") Long questionId, @RequestBody RequestInput input) {
		try {
			String questionText = input.getText();
			Assert.notNull(questionText, "Soru alanı boş geçilemez.");

			service.updateQuestion(questionId, questionText);

			ApiResponse<String> response = new ApiResponse<>();
			response.setMessage("Kayıt güncelleme başarılı.");
			response.setStatus(true);
			return response;
		} catch (DataNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
