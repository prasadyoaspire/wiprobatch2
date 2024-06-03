package com.abc.registration.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Registration {

	private int registrationId;
	private LocalDate dateOfRegistration;
	private Student student;
	private Course course;
	private double amountPaid;
	private double amountDue;
}
