package com.abc.registration.service;

import java.util.List;

import com.abc.registration.entity.RegistrationEntity;

public interface RegistrationService {

	RegistrationEntity register(RegistrationEntity registrationEntity);
	
	RegistrationEntity findRegistrationDetailsById(int registrationId);
	
	List<RegistrationEntity> findAllRegistrations();
}
