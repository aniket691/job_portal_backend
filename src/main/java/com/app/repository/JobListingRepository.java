package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.JobListing;

public interface JobListingRepository extends JpaRepository<JobListing, Long> {

}
