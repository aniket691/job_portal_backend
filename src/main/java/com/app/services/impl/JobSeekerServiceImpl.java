package com.app.services.impl;

import com.app.dto.JobSeekerDTO;
import com.app.dto.ImageDataDTO;
import com.app.entity.ImageData;
import com.app.entity.JobSeeker;
import com.app.entity.Skill;
import com.app.entity.Subscription;
import com.app.repository.JobSeekerRepository;
import com.app.repository.ImageDataRepository;
import com.app.repository.SkillRepository;
import com.app.repository.SubscriptionRepository;
import com.app.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class JobSeekerServiceImpl implements JobSeekerService {

	@Autowired
	private JobSeekerRepository jobSeekerRepository;

	@Autowired
	private SkillRepository skillRepository;

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Autowired
	private ImageDataRepository imageDataRepository;

	@Override
	public JobSeekerDTO createJobSeeker(JobSeekerDTO jobSeekerDTO, MultipartFile resumeFile) {
		JobSeeker jobSeeker = convertToEntity(jobSeekerDTO);

		// Save resume if provided
		if (resumeFile != null && !resumeFile.isEmpty()) {
			ImageData imageData = saveResumeFile(resumeFile);
			jobSeeker.setJobSeekerResume(imageData);
		}

		JobSeeker savedJobSeeker = jobSeekerRepository.save(jobSeeker);
		return convertToDTO(savedJobSeeker);
	}

	@Override
	public JobSeekerDTO getJobSeekerById(Long jobSeekerId) {
		JobSeeker jobSeeker = jobSeekerRepository.findById(jobSeekerId)
				.orElseThrow(() -> new RuntimeException("JobSeeker not found with id " + jobSeekerId));
		return convertToDTO(jobSeeker);
	}

	@Override
	public List<JobSeekerDTO> getAllJobSeekers() {
		List<JobSeeker> jobSeekers = jobSeekerRepository.findAll();
		return jobSeekers.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public JobSeekerDTO updateJobSeeker(Long jobSeekerId, JobSeekerDTO jobSeekerDTO, MultipartFile resumeFile) {
		JobSeeker jobSeeker = jobSeekerRepository.findById(jobSeekerId)
				.orElseThrow(() -> new RuntimeException("JobSeeker not found with id " + jobSeekerId));

		jobSeeker.setJobSeekerFullName(jobSeekerDTO.getJobSeekerFullName());
		jobSeeker.setJobSeekerMobileNumber(jobSeekerDTO.getJobSeekerMobileNumber());
		jobSeeker.setJobSeekerProfileSummary(jobSeekerDTO.getJobSeekerProfileSummary());
		jobSeeker.setJobSeekerExperience(jobSeekerDTO.getJobSeekerExperience());
		jobSeeker.setJobSeekerEmail(jobSeekerDTO.getJobSeekerEmail());
		jobSeeker.setJobSeekerPassword(jobSeekerDTO.getJobSeekerPassword());
		jobSeeker.setLocation(jobSeekerDTO.getLocation());

		if (jobSeekerDTO.getSkillId() != null) {
			Skill skill = skillRepository.findById(jobSeekerDTO.getSkillId())
					.orElseThrow(() -> new RuntimeException("Skill not found with id " + jobSeekerDTO.getSkillId()));
			jobSeeker.setSkill(skill);
		}

		if (jobSeekerDTO.getSubscriptionId() != null) {
			Subscription subscription = subscriptionRepository.findById(jobSeekerDTO.getSubscriptionId()).orElseThrow(
					() -> new RuntimeException("Subscription not found with id " + jobSeekerDTO.getSubscriptionId()));
			jobSeeker.setSubscription(subscription);
		}

		// Update resume if provided
		if (resumeFile != null && !resumeFile.isEmpty()) {
			ImageData imageData = saveResumeFile(resumeFile);
			jobSeeker.setJobSeekerResume(imageData);
		}

		JobSeeker updatedJobSeeker = jobSeekerRepository.save(jobSeeker);
		return convertToDTO(updatedJobSeeker);
	}

	@Override
	public void deleteJobSeeker(Long jobSeekerId) {
		jobSeekerRepository.deleteById(jobSeekerId);
	}

	@Override
	public Optional<JobSeeker> login(String email, String password) {
		return jobSeekerRepository.findByJobSeekerEmailAndJobSeekerPassword(email, password);
	}

	@Override
	public JobSeekerDTO updateResume(Long jobSeekerId, JobSeekerDTO jobSeekerDTO, MultipartFile resumeFile) {
		JobSeeker jobSeeker = jobSeekerRepository.findById(jobSeekerId)
				.orElseThrow(() -> new RuntimeException("JobSeeker not found with id " + jobSeekerId));

		if (resumeFile != null && !resumeFile.isEmpty()) {
			ImageData imageData = saveResumeFile(resumeFile);
			jobSeeker.setJobSeekerResume(imageData);
		}

		JobSeeker updatedJobSeeker = jobSeekerRepository.save(jobSeeker);
		return convertToDTO(updatedJobSeeker);
	}

	private ImageData saveResumeFile(MultipartFile resumeFile) {
		try {
			return ImageData.builder().name(resumeFile.getOriginalFilename()).type(resumeFile.getContentType())
					.imageData(resumeFile.getBytes()).build();
		} catch (IOException e) {
			throw new RuntimeException("Error saving resume file", e);
		}
	}

	private JobSeekerDTO convertToDTO(JobSeeker jobSeeker) {
		ImageDataDTO imageDataDTO = null;
		if (jobSeeker.getJobSeekerResume() != null) {
			imageDataDTO = new ImageDataDTO(jobSeeker.getJobSeekerResume().getId(),
					jobSeeker.getJobSeekerResume().getName(), jobSeeker.getJobSeekerResume().getType());
		}

		return new JobSeekerDTO(jobSeeker.getJobSeekerId(), jobSeeker.getJobSeekerFullName(),
				jobSeeker.getJobSeekerMobileNumber(), jobSeeker.getJobSeekerProfileSummary(),
				jobSeeker.getJobSeekerExperience(), imageDataDTO, jobSeeker.getJobSeekerEmail(),
				jobSeeker.getJobSeekerPassword(), jobSeeker.getLocation(),
				jobSeeker.getSkill() != null ? jobSeeker.getSkill().getSkillId() : null,
				jobSeeker.getSubscription() != null ? jobSeeker.getSubscription().getSubscriptionId() : null);
	}

	private JobSeeker convertToEntity(JobSeekerDTO jobSeekerDTO) {
		JobSeeker jobSeeker = new JobSeeker();
		jobSeeker.setJobSeekerId(jobSeekerDTO.getJobSeekerId());
		jobSeeker.setJobSeekerFullName(jobSeekerDTO.getJobSeekerFullName());
		jobSeeker.setJobSeekerMobileNumber(jobSeekerDTO.getJobSeekerMobileNumber());
		jobSeeker.setJobSeekerProfileSummary(jobSeekerDTO.getJobSeekerProfileSummary());
		jobSeeker.setJobSeekerExperience(jobSeekerDTO.getJobSeekerExperience());
		jobSeeker.setJobSeekerEmail(jobSeekerDTO.getJobSeekerEmail());
		jobSeeker.setJobSeekerPassword(jobSeekerDTO.getJobSeekerPassword());
		jobSeeker.setLocation(jobSeekerDTO.getLocation());

		if (jobSeekerDTO.getSkillId() != null) {
			Skill skill = skillRepository.findById(jobSeekerDTO.getSkillId())
					.orElseThrow(() -> new RuntimeException("Skill not found with id " + jobSeekerDTO.getSkillId()));
			jobSeeker.setSkill(skill);
		}

		if (jobSeekerDTO.getSubscriptionId() != null) {
			Subscription subscription = subscriptionRepository.findById(jobSeekerDTO.getSubscriptionId()).orElseThrow(
					() -> new RuntimeException("Subscription not found with id " + jobSeekerDTO.getSubscriptionId()));
			jobSeeker.setSubscription(subscription);
		}

		return jobSeeker;
	}
}
