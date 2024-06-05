package com.abc.authservice.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginPayload {

	private String username;
	private String password;
}
