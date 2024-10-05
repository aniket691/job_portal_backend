package com.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_id")
	private Long feedbackId;

	@Column(name = "feedback_title", nullable = false)
	private String feedbackTitle;

	@Column(name = "feedback_description", nullable = false)
	private String feedbackDescription;

	@ManyToOne
	@JoinColumn(name = "jobseeker_id", nullable = false)
	private JobSeeker jobSeeker;

	// Constructors
	public Feedback() {
		super();
	}

	public Feedback(Long feedbackId, String feedbackTitle, String feedbackDescription, JobSeeker jobSeeker) {
		super();
		this.feedbackId = feedbackId;
		this.feedbackTitle = feedbackTitle;
		this.feedbackDescription = feedbackDescription;
		this.jobSeeker = jobSeeker;
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

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	@Override
	public String toString() {
		return "Feedback{" + "feedbackId=" + feedbackId + ", feedbackTitle='" + feedbackTitle + '\''
				+ ", feedbackDescription='" + feedbackDescription + '\'' + ", jobSeeker=" + jobSeeker + '}';
	}
}
