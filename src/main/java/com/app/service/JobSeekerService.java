package com.app.service;

import com.app.dto.JobSeekerDTO;
import com.app.entity.JobSeeker;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface JobSeekerService {
	JobSeekerDTO createJobSeeker(JobSeekerDTO jobSeekerDTO, MultipartFile resumeFile);

	JobSeekerDTO getJobSeekerById(Long jobSeekerId);

	List<JobSeekerDTO> getAllJobSeekers();

	JobSeekerDTO updateJobSeeker(Long jobSeekerId, JobSeekerDTO jobSeekerDTO, MultipartFile resumeFile);

	void deleteJobSeeker(Long jobSeekerId);

	Optional<JobSeeker> login(String email, String password);

	JobSeekerDTO updateResume(Long jobSeekerId, JobSeekerDTO jobSeekerDTO, MultipartFile resumeFile);
}
