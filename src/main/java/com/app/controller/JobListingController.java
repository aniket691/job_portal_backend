package com.app.controller;

import com.app.dto.JobListingDTO;
import com.app.service.JobListingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/joblistings")
@CrossOrigin("*")
public class JobListingController {

	@Autowired
	private JobListingService jobListingService;

	@PostMapping
	public ResponseEntity<JobListingDTO> createJobListing(@RequestBody JobListingDTO jobListingDTO) {
		JobListingDTO createdJobListing = jobListingService.createJobListing(jobListingDTO);
		return ResponseEntity.ok(createdJobListing);
	}

	@GetMapping("/{jobId}")
	public ResponseEntity<JobListingDTO> getJobListingById(@PathVariable Long jobId) {
		JobListingDTO jobListingDTO = jobListingService.getJobListingById(jobId);
		return ResponseEntity.ok(jobListingDTO);
	}

	@GetMapping
	public ResponseEntity<List<JobListingDTO>> getAllJobListings() {
		List<JobListingDTO> jobListings = jobListingService.getAllJobListings();
		return ResponseEntity.ok(jobListings);
	}

	
	@PutMapping("/{jobId}")
	public ResponseEntity<JobListingDTO> updateJobListing(@PathVariable Long jobId,
			@RequestBody JobListingDTO jobListingDTO) {
		JobListingDTO updatedJobListing = jobListingService.updateJobListing(jobId, jobListingDTO);
		return ResponseEntity.ok(updatedJobListing);
	}

	@DeleteMapping("/{jobId}")
	public ResponseEntity<Void> deleteJobListing(@PathVariable Long jobId) {
		jobListingService.deleteJobListing(jobId);
		return ResponseEntity.noContent().build();
	}
}