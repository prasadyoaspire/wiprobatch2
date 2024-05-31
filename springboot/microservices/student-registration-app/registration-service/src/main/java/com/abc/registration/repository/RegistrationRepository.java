package com.abc.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.registration.entity.RegistrationEntity;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity,Integer> {

}
