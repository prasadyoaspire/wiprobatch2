package com.abc.registration.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private int studentId;	
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private String mobile;
}
