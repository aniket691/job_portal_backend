package com.app.service;

import java.util.List;

import com.app.dto.JobListingDTO;

public interface JobListingService {
	JobListingDTO createJobListing(JobListingDTO jobListingDTO);

	JobListingDTO getJobListingById(Long jobId);

	List<JobListingDTO> getAllJobListings();

	JobListingDTO updateJobListing(Long jobId, JobListingDTO jobListingDTO);

	void deleteJobListing(Long jobId);
}