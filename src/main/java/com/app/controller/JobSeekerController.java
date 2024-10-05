package com.app.controller;

import com.app.dto.JobSeekerDTO;
import com.app.dto.LoginRequest;
import com.app.entity.JobSeeker;
import com.app.service.JobSeekerService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin("*")
public class JobSeekerController {

	@Autowired
	private JobSeekerService jobSeekerService;

	@PostMapping("/createJobSeeker")
	public ResponseEntity<?> createJobSeeker(@RequestPart("jobSeekerDTO") String jobSeekerDTO,
			@RequestPart("resumeFile") MultipartFile resumeFile) {

		try {
			// Convert the jobSeekerDTO string to an object
			ObjectMapper objectMapper = new ObjectMapper();
			JobSeekerDTO jobSeeker = objectMapper.readValue(jobSeekerDTO, JobSeekerDTO.class);

			// Save the job seeker using your service
			JobSeekerDTO createdJobSeeker = jobSeekerService.createJobSeeker(jobSeeker, resumeFile);
			return ResponseEntity.ok(createdJobSeeker);
		} catch (IOException e) {
			return ResponseEntity.badRequest().body("Error parsing job seeker data: " + e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body("Error creating job seeker: " + e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<JobSeekerDTO> getJobSeekerById(@PathVariable Long id) {
		JobSeekerDTO jobSeekerDTO = jobSeekerService.getJobSeekerById(id);
		return ResponseEntity.ok(jobSeekerDTO);
	}

	@GetMapping
	public ResponseEntity<List<JobSeekerDTO>> getAllJobSeekers() {
		List<JobSeekerDTO> jobSeekers = jobSeekerService.getAllJobSeekers();
		return ResponseEntity.ok(jobSeekers);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateJobSeeker(@PathVariable Long id,
			@RequestPart("jobSeekerDTO") JobSeekerDTO jobSeekerDTO,
			@RequestPart(value = "resumeFile", required = false) MultipartFile resumeFile) {

		try {
			JobSeekerDTO updatedJobSeeker = jobSeekerService.updateJobSeeker(id, jobSeekerDTO, resumeFile);
			return ResponseEntity.ok(updatedJobSeeker);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body("Error updating job seeker: " + e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteJobSeeker(@PathVariable Long id) {
		jobSeekerService.deleteJobSeeker(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		Optional<JobSeeker> jobSeeker = jobSeekerService.login(loginRequest.getEmail(), loginRequest.getPassword());
		if (jobSeeker.isPresent()) {
			return ResponseEntity.ok(jobSeeker.get());
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
		}
	}
}
