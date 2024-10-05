package com.app.service;

import com.app.dto.FeedbackDTO;
import com.app.dto.JobSeekerDTO;
import java.util.List;
import java.util.Optional;

public interface FeedbackService {
	FeedbackDTO createFeedback(FeedbackDTO feedbackDTO);

	List<FeedbackDTO> getAllFeedbacks();

	Optional<FeedbackDTO> getFeedbackById(Long id);

	FeedbackDTO updateFeedback(Long id, FeedbackDTO feedbackDTO);

	void deleteFeedback(Long id);

	List<FeedbackDTO> getFeedbacksByJobSeeker(JobSeekerDTO jobSeekerDTO);
}
