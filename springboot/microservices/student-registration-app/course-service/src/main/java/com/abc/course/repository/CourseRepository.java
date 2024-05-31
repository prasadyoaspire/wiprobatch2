package com.abc.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.course.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {

}
