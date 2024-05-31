package com.abc.registration.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.registration.entity.RegistrationEntity;
import com.abc.registration.exception.ResourseNotFoundException;
import com.abc.registration.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl  implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Override
	public RegistrationEntity register(RegistrationEntity registrationEntity) {
		
		registrationEntity.setDateOfRegistration(LocalDate.now());
		registrationEntity.setAmountDue(0);
		
		registrationRepository.save(registrationEntity);
		return registrationEntity;
	}

	@Override
	public RegistrationEntity findRegistrationDetailsById(int registrationId) {
		
		Optional<RegistrationEntity> optionalRegistration = registrationRepository.findById(registrationId);
		if(optionalRegistration.isEmpty()) {
			throw new ResourseNotFoundException("No registation with id: "+registrationId);
		}
		RegistrationEntity  registrationEntity = optionalRegistration.get();
		
		return registrationEntity;
	}

	@Override
	public List<RegistrationEntity> findAllRegistrations() {
		
		return registrationRepository.findAll();
	}

}
