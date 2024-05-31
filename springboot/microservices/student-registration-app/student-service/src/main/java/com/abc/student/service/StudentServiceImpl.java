package com.abc.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.student.entity.StudentEntity;
import com.abc.student.exception.ResourseNotFoundException;
import com.abc.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentEntity saveStudent(StudentEntity studentEntity) {
		
		studentRepository.save(studentEntity);		
		return studentEntity;
	}

	@Override
	public StudentEntity findStudentById(int studentId) {
		
		Optional<StudentEntity> optionalStudent = studentRepository.findById(studentId);
		if(optionalStudent.isEmpty()) {
			throw new ResourseNotFoundException("Student not found with id: "+studentId);
		}
		StudentEntity studentEntity = optionalStudent.get();
		
		return studentEntity;
	}

	@Override
	public List<StudentEntity> findAllStudent() {
		
		return studentRepository.findAll();
	}

}
