package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Recruiter;

public interface RecruiterRepository extends JpaRepository<Recruiter,Long> {
	Optional<Recruiter> findByRecruiterEmailAndRecruiterPassword(String email, String password);
	Optional<Recruiter> findByRecruiterEmail(String name);
}
