package com.abc.ecomapp.service;

import java.util.List;

import com.abc.ecomapp.entity.User;

public interface UserService {

	User saveUser(User user);
	User findUserById(int userId);
	List<User> findAllUsers();
	
	User doLogin(String username,String password);
	
}
