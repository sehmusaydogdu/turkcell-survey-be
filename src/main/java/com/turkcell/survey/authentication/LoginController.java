package com.turkcell.survey.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.turkcell.survey.authentication.model.request.UserInput;
import com.turkcell.survey.authentication.model.response.UserOutput;
import com.turkcell.survey.exception.DataNotFoundException;
import com.turkcell.survey.exception.UserAlreadyLoggedException;
import com.turkcell.survey.exception.WrondUserCredentialException;

@RestController
public class LoginController {

	@Autowired
	private ILoginService service;

	@PostMapping("/api/login")
	public ResponseEntity<UserOutput> login(@RequestBody UserInput userDto) {
		try {
			UserOutput userOutput = service.login(userDto.getUsername(), userDto.getPassword());
			return ResponseEntity.ok(userOutput);
		} catch (DataNotFoundException | WrondUserCredentialException | UserAlreadyLoggedException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/api/logout")
	public ResponseEntity<String> logout() {
		service.logout();
		return ResponseEntity.ok("Oturum sonlandırılmıştır.");
	}
}
