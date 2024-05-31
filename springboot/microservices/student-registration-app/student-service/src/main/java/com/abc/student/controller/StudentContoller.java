package com.abc.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.student.entity.StudentEntity;
import com.abc.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentContoller {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity studentEntity) {
		studentService.saveStudent(studentEntity);
		return new ResponseEntity<>(studentEntity,HttpStatus.CREATED);
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<StudentEntity> getStudentDetails(@PathVariable int studentId) {
		StudentEntity studentEntity = studentService.findStudentById(studentId);
		return new ResponseEntity<>(studentEntity,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<StudentEntity> geAlltStudents() {		
		return studentService.findAllStudent();
	}
}
