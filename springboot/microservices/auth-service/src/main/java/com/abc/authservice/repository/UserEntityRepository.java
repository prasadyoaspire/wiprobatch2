package com.abc.authservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.authservice.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer>{

	 Optional<UserEntity> findByUsername(String username);
}
