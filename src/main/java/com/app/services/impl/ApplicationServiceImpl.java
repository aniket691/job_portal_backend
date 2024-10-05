package com.app.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApplicationDTO;
import com.app.dto.ApplicationDetailDTO;
import com.app.entity.Application;
import com.app.entity.ApplicationStatus;
import com.app.entity.JobListing;
import com.app.entity.JobSeeker;
import com.app.repository.ApplicationRepository;
import com.app.repository.JobListingRepository;
import com.app.repository.JobSeekerRepository;
import com.app.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationRepository applicationRepository;

	@Autowired
	private JobSeekerRepository jobSeekerRepository;

	@Autowired
	private JobListingRepository jobListingRepository;

	@Override
	public Application saveApplication(ApplicationDTO applicationDTO) {

		JobSeeker jobSeeker = jobSeekerRepository.findById(applicationDTO.getJobSeekerId())
				.orElseThrow(() -> new RuntimeException("Job Seeker not found"));

		JobListing jobListing = jobListingRepository.findById(applicationDTO.getJobId())
				.orElseThrow(() -> new RuntimeException("Job Listing not found"));

		Application application = new Application();
		application.setJobSeeker(jobSeeker);
		application.setJobListing(jobListing);
		application.setApplicationStatus(ApplicationStatus.APPLIED); // Set default status

		return applicationRepository.save(application);
	}

	@Override
	public List<Application> getApplicationsByJobListingId(Long jobListingId) {
		return applicationRepository.findByJobListing_JobId(jobListingId);
	}

	@Override
	public void deleteApplication(Long applicationId) {
		applicationRepository.deleteById(applicationId);
	}

	@Override
	public List<Application> getAllApplications() {
		// TODO Auto-generated method stub
		return applicationRepository.findAll();
	}

	@Override
	public List<ApplicationDetailDTO> getAllApplicationDetails() {
		// Fetch all applications
		List<Application> applications = applicationRepository.findAll();

		// Transform each application to ApplicationDetailDTO
		return applications.stream()
				.map(application -> new ApplicationDetailDTO(application.getApplicationId(),
						application.getApplicationStatus().name(), // Assuming ApplicationStatus is an enum
						application.getJobListing().getJobTitle(), application.getJobSeeker().getJobSeekerFullName()))
				.collect(Collectors.toList());
	}

	@Override
	public Application updateApplicationStatus(Long applicationId, String status) {
		Application application = applicationRepository.findById(applicationId)
				.orElseThrow(() -> new RuntimeException("Application not found"));
		application.setApplicationStatus(ApplicationStatus.valueOf(status));
		return applicationRepository.save(application);
	}

}