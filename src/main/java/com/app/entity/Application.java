package com.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "application")
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "application_id")
	private Long applicationId;

	@Enumerated(EnumType.STRING)
	@Column(name = "application_status", nullable = false)
	private ApplicationStatus applicationStatus;

	@ManyToOne
	@JoinColumn(name = "jobseeker_id", nullable = false)
	private JobSeeker jobSeeker;

	@ManyToOne
	@JoinColumn(name = "job_id", nullable = false)
	private JobListing jobListing;

	// Constructors
	public Application() {
		super();
	}

	public Application(Long applicationId, ApplicationStatus applicationStatus, JobSeeker jobSeeker,
			JobListing jobListing) {
		this.applicationId = applicationId;
		this.applicationStatus = applicationStatus;
		this.jobSeeker = jobSeeker;
		this.jobListing = jobListing;
	}

	// Getters and Setters
	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public JobListing getJobListing() {
		return jobListing;
	}

	public void setJobListing(JobListing jobListing) {
		this.jobListing = jobListing;
	}

	@Override
	public String toString() {
		return "Application{" + "applicationId=" + applicationId + ", applicationStatus=" + applicationStatus
				+ ", jobSeeker=" + jobSeeker + ", jobListing=" + jobListing + '}';
	}
}
