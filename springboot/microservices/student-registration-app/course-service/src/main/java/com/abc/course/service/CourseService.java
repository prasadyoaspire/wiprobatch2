package com.abc.course.service;

import java.util.List;

import com.abc.course.entity.CourseEntity;

public interface CourseService {

	CourseEntity saveCourse(CourseEntity courseEntity);
	
	CourseEntity findCourseById(int courseId);
	
	List<CourseEntity> findAllCourses();
}
