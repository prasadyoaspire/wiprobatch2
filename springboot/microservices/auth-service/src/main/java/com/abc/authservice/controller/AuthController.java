package com.abc.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.authservice.entity.UserEntity;
import com.abc.authservice.model.LoginPayload;
import com.abc.authservice.service.AuthServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthServiceImpl authSerivceImpl;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public ResponseEntity<String> registration(@RequestBody UserEntity userEntity) {		
		String msg = authSerivceImpl.saveUser(userEntity);
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public String doLogin(@RequestBody LoginPayload loginPayload) {
        Authentication authenticate = authenticationManager.authenticate(
        		new UsernamePasswordAuthenticationToken(loginPayload.getUsername(), loginPayload.getPassword()));
        if (authenticate.isAuthenticated()) {
            return authSerivceImpl.generateToken(loginPayload.getUsername());
        } else {
            throw new RuntimeException("invalid access");
        }
	}
	
    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
    	authSerivceImpl.validateToken(token);
        return "Token is valid";
    }

}
