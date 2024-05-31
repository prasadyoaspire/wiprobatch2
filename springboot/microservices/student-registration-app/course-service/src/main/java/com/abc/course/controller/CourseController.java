package com.abc.course.controller;

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

import com.abc.course.entity.CourseEntity;
import com.abc.course.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping("/save")
	public ResponseEntity<CourseEntity> createCourse(@RequestBody CourseEntity courseEntity) {
		courseService.saveCourse(courseEntity);
		return new ResponseEntity<>(courseEntity,HttpStatus.CREATED);
	}
	
	@GetMapping("/{courseId}")
	public ResponseEntity<CourseEntity> getCourseDetails(@PathVariable int courseId) {
		CourseEntity courseEntity = courseService.findCourseById(courseId);
		return new ResponseEntity<>(courseEntity,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<CourseEntity> geAlltStudents() {		
		return courseService.findAllCourses();
	}
}
