package com.abc.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.course.entity.CourseEntity;
import com.abc.course.exception.ResourseNotFoundException;
import com.abc.course.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public CourseEntity saveCourse(CourseEntity courseEntity) {
		courseRepository.save(courseEntity);		
		return courseEntity;
	}

	@Override
	public CourseEntity findCourseById(int courseId) {
		Optional<CourseEntity> optionalCourse = courseRepository.findById(courseId);
		if(optionalCourse.isEmpty()) {
			throw new ResourseNotFoundException("Course not found with id: "+courseId);		
		}		
		CourseEntity courseEntity = optionalCourse.get();
		return courseEntity;
	}

	@Override
	public List<CourseEntity> findAllCourses() {
		
		return courseRepository.findAll();
	}

}
