package com.abc.registration.service;

import java.util.List;

import com.abc.registration.entity.RegistrationEntity;
import com.abc.registration.model.Registration;

public interface RegistrationService {

	RegistrationEntity register(RegistrationEntity registrationEntity);
	
	Registration findRegistrationDetailsById(int registrationId);
	
	List<RegistrationEntity> findAllRegistrations();
}
