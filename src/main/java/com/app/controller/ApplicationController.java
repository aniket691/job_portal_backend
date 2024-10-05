package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApplicationDTO;
import com.app.dto.ApplicationDetailDTO;
import com.app.dto.StatusUpdateRequest;
import com.app.entity.Application;
import com.app.service.ApplicationService;

@RestController
@RequestMapping("/applications")
@CrossOrigin("*")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	@PostMapping("/createApplication")
	public ResponseEntity<Application> createApplication(@RequestBody ApplicationDTO applicationDTO) {
		Application savedApplication = applicationService.saveApplication(applicationDTO);
		return ResponseEntity.ok(savedApplication);
	}

	@GetMapping("/job/{jobListingId}")
	public ResponseEntity<List<Application>> getApplicationsByJobListingId(@PathVariable Long jobListingId) {
		List<Application> applications = applicationService.getApplicationsByJobListingId(jobListingId);
		return ResponseEntity.ok(applications);
	}

	@DeleteMapping("/{applicationId}")
	public ResponseEntity<Void> deleteApplication(@PathVariable Long applicationId) {
		applicationService.deleteApplication(applicationId);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/getAllApplications")
	public List<Application> getAllApplications() {
		return applicationService.getAllApplications();
	}

	@GetMapping("/details")
	public ResponseEntity<List<ApplicationDetailDTO>> getAllApplicationDetails() {
		List<ApplicationDetailDTO> applicationDetails = applicationService.getAllApplicationDetails();
		return ResponseEntity.ok(applicationDetails);
	}

	@PutMapping("/{applicationId}/status")
	public ResponseEntity<Application> updateApplicationStatus(@PathVariable("applicationId") Long applicationId,
			@RequestBody StatusUpdateRequest request) {
		Application updatedApplication = applicationService.updateApplicationStatus(applicationId, request.getStatus());
		return ResponseEntity.ok(updatedApplication);
	}

}