package com.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.rest.model.User;
import com.spring.rest.model.JwtRequest;
import com.spring.rest.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/signUp")
	public ResponseEntity<Object> signUp(@RequestBody User customUser) {

		return authService.signUp(customUser);
	}

	@PostMapping("/signIn")
	public ResponseEntity<Object> signIn(@RequestBody JwtRequest jwtRequest) {

		return authService.signIn(jwtRequest);

	}

}
