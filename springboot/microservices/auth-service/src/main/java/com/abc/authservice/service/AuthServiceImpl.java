package com.abc.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.abc.authservice.entity.UserEntity;
import com.abc.authservice.repository.UserEntityRepository;

@Service
public class AuthServiceImpl {

	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public String saveUser(UserEntity userEntity) {		
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));		
		userEntityRepository.save(userEntity);		
		return "User Added.";		
	}
	
	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}
	
	
	public void validateToken(String token) {
		jwtService.validateToken(token);
	}	
}
