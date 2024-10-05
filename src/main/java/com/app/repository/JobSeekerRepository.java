package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {
	Optional<JobSeeker> findByJobSeekerEmailAndJobSeekerPassword(String email, String password);
}
