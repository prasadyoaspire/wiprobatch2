package com.abc.registration.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abc.registration.entity.RegistrationEntity;
import com.abc.registration.exception.ResourseNotFoundException;
import com.abc.registration.model.Course;
import com.abc.registration.model.Registration;
import com.abc.registration.model.Student;
import com.abc.registration.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl  implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public RegistrationEntity register(RegistrationEntity registrationEntity) {
		
		ResponseEntity<Course> responseEntity = restTemplate.getForEntity("http://localhost:7072/course/"+registrationEntity.getCourseId(), Course.class);
		Course course = responseEntity.getBody();
		double courseFees = course.getFees();
		double amountDue = courseFees - registrationEntity.getAmountPaid();
				
		registrationEntity.setDateOfRegistration(LocalDate.now());
		registrationEntity.setAmountDue(amountDue);
		
		registrationRepository.save(registrationEntity);
		return registrationEntity;
	}

	@Override
	public Registration findRegistrationDetailsById(int registrationId) {
		
		Optional<RegistrationEntity> optionalRegistration = registrationRepository.findById(registrationId);
		if(optionalRegistration.isEmpty()) {
			throw new ResourseNotFoundException("No registation with id: "+registrationId);
		}
		RegistrationEntity  registrationEntity = optionalRegistration.get();
		
		ResponseEntity<Course> courseresponseEntity = restTemplate.getForEntity("http://localhost:7072/course/"+registrationEntity.getCourseId(), Course.class);
		Course course = courseresponseEntity.getBody();
		
		ResponseEntity<Student> studentResponseEntity = restTemplate.getForEntity("http://localhost:7071/student/"+registrationEntity.getStudentId(), Student.class);
		Student student = studentResponseEntity.getBody();
		
		Registration registration = new Registration();
		registration.setRegistrationId(registrationEntity.getRegistrationId());
		registration.setDateOfRegistration(registrationEntity.getDateOfRegistration());
		registration.setAmountPaid(registrationEntity.getAmountPaid());
		registration.setAmountDue(registrationEntity.getAmountDue());
		registration.setStudent(student);
		registration.setCourse(course);
		
		return registration;
	}

	@Override
	public List<RegistrationEntity> findAllRegistrations() {
		
		return registrationRepository.findAll();
	}

}
