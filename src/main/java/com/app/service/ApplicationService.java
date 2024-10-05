package com.app.service;

import java.util.List;

import com.app.dto.ApplicationDTO;
import com.app.dto.ApplicationDetailDTO;
import com.app.entity.Application;
import com.app.entity.ApplicationStatus;

public interface ApplicationService {
	Application saveApplication(ApplicationDTO applicationDTO);

	List<Application> getApplicationsByJobListingId(Long jobListingId);

//	Application updateApplicationStatus(Long applicationId, ApplicationStatus status);

	void deleteApplication(Long applicationId);

	List<Application> getAllApplications();

	List<ApplicationDetailDTO> getAllApplicationDetails();

	Application updateApplicationStatus(Long applicationId, String status);
}