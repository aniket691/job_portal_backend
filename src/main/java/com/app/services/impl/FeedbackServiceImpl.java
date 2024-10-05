package com.app.services.impl;

import com.app.dto.FeedbackDTO;
import com.app.dto.JobSeekerDTO;
import com.app.entity.Feedback;
import com.app.entity.JobSeeker;
import com.app.entity.Skill;
import com.app.entity.Subscription;
import com.app.repository.FeedbackRepository;
import com.app.repository.JobSeekerRepository;
import com.app.repository.SkillRepository;
import com.app.repository.SubscriptionRepository;
import com.app.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Autowired
	private JobSeekerRepository jobSeekerRepository;

	@Autowired
	private SkillRepository skillRepository;

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Override
	public FeedbackDTO createFeedback(FeedbackDTO feedbackDTO) {
		if (feedbackDTO.getJobSeekerId() == null) {
			throw new IllegalArgumentException("The given jobSeekerId must not be null!");
		}
		Feedback feedback = mapToEntity(feedbackDTO);
		Feedback savedFeedback = feedbackRepository.save(feedback);
		return mapToDTO(savedFeedback);
	}

	@Override
	public List<FeedbackDTO> getAllFeedbacks() {
		List<Feedback> feedbacks = feedbackRepository.findAll();
		return feedbacks.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public Optional<FeedbackDTO> getFeedbackById(Long id) {
		Optional<Feedback> feedback = feedbackRepository.findById(id);
		return feedback.map(this::mapToDTO);
	}

	@Override
	public FeedbackDTO updateFeedback(Long id, FeedbackDTO feedbackDTO) {
		if (feedbackDTO.getJobSeekerId() == null) {
			throw new IllegalArgumentException("The given jobSeekerId must not be null!");
		}
		Optional<Feedback> optionalFeedback = feedbackRepository.findById(id);
		if (optionalFeedback.isPresent()) {
			Feedback feedback = optionalFeedback.get();
			feedback.setFeedbackTitle(feedbackDTO.getFeedbackTitle());
			feedback.setFeedbackDescription(feedbackDTO.getFeedbackDescription());
			feedback.setJobSeeker(jobSeekerRepository.findById(feedbackDTO.getJobSeekerId()).orElse(null));
			Feedback updatedFeedback = feedbackRepository.save(feedback);
			return mapToDTO(updatedFeedback);
		} else {
			return null;
		}
	}

	@Override
	public void deleteFeedback(Long id) {
		feedbackRepository.deleteById(id);
	}

	@Override
	public List<FeedbackDTO> getFeedbacksByJobSeeker(JobSeekerDTO jobSeekerDTO) {
		JobSeeker jobSeeker = convertToEntity(jobSeekerDTO);
		List<Feedback> feedbacks = feedbackRepository.findByJobSeeker(jobSeeker);
		return feedbacks.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	private FeedbackDTO mapToDTO(Feedback feedback) {
		FeedbackDTO feedbackDTO = new FeedbackDTO();
		feedbackDTO.setFeedbackId(feedback.getFeedbackId());
		feedbackDTO.setFeedbackTitle(feedback.getFeedbackTitle());
		feedbackDTO.setFeedbackDescription(feedback.getFeedbackDescription());
		feedbackDTO.setJobSeekerId(feedback.getJobSeeker().getJobSeekerId());
		return feedbackDTO;
	}

	private Feedback mapToEntity(FeedbackDTO feedbackDTO) {
		Feedback feedback = new Feedback();
		feedback.setFeedbackId(feedbackDTO.getFeedbackId());
		feedback.setFeedbackTitle(feedbackDTO.getFeedbackTitle());
		feedback.setFeedbackDescription(feedbackDTO.getFeedbackDescription());
		feedback.setJobSeeker(jobSeekerRepository.findById(feedbackDTO.getJobSeekerId()).orElse(null));
		return feedback;
	}

//	private JobSeekerDTO mapToDTO(JobSeeker jobSeeker) {
//		JobSeekerDTO jobSeekerDTO = new JobSeekerDTO();
//		jobSeekerDTO.setJobSeekerId(jobSeeker.getJobSeekerId());
//		jobSeekerDTO.setJobSeekerFullName(jobSeeker.getJobSeekerFullName());
//		jobSeekerDTO.setJobSeekerMobileNumber(jobSeeker.getJobSeekerMobileNumber());
//		jobSeekerDTO.setJobSeekerProfileSummary(jobSeeker.getJobSeekerProfileSummary());
//		jobSeekerDTO.setJobSeekerExperience(jobSeeker.getJobSeekerExperience());
//		jobSeekerDTO.setJobSeekerResume(jobSeeker.getJobSeekerResume());
//		jobSeekerDTO.setJobSeekerEmail(jobSeeker.getJobSeekerEmail());
//		jobSeekerDTO.setJobSeekerPassword(jobSeeker.getJobSeekerPassword());
//		jobSeekerDTO.setSkillId(jobSeeker.getSkill() != null ? jobSeeker.getSkill().getSkillId() : null);
//		jobSeekerDTO.setSubscriptionId(
//				jobSeeker.getSubscription() != null ? jobSeeker.getSubscription().getSubscriptionId() : null);
//		return jobSeekerDTO;
//	}

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
