package com.firatergun.gatewaydemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firatergun.gatewaydemo.entity.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long>{
	Optional<ApplicationUser> findByUsername (String username);
}
