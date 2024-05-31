package com.abc.student.service;

import java.util.List;

import com.abc.student.entity.StudentEntity;

public interface StudentService {

	StudentEntity saveStudent(StudentEntity studentEntity);
	StudentEntity findStudentById(int studentId);
	List<StudentEntity> findAllStudent();
}
