package com.app.repository;

import com.app.entity.Feedback;
import com.app.entity.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
	List<Feedback> findByJobSeeker(JobSeeker jobSeeker);
}