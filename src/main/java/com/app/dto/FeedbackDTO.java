package com.app.dto;

public class FeedbackDTO {

	private Long feedbackId;
	private String feedbackTitle;
	private String feedbackDescription;
	private Long jobSeekerId;

	// Constructors
	public FeedbackDTO() {
	}

	public FeedbackDTO(Long feedbackId, String feedbackTitle, String feedbackDescription, Long jobSeekerId) {
		this.feedbackId = feedbackId;
		this.feedbackTitle = feedbackTitle;
		this.feedbackDescription = feedbackDescription;
		this.jobSeekerId = jobSeekerId;
	}

	// Getters and Setters
	public Long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackTitle() {
		return feedbackTitle;
	}

	public void setFeedbackTitle(String feedbackTitle) {
		this.feedbackTitle = feedbackTitle;
	}

	public String getFeedbackDescription() {
		return feedbackDescription;
	}

	public void setFeedbackDescription(String feedbackDescription) {
		this.feedbackDescription = feedbackDescription;
	}

	public Long getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(Long jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}
}
