package com.abc.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.student.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer>{

}
