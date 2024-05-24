package com.abc.ecomapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.ecomapp.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	@Query("select u from User u where u.userName = :uname and u.password = :upwd")
	User login(@Param("uname") String username, @Param("upwd") String password);
}
