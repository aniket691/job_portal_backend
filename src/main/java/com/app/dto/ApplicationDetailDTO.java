package com.app.dto;

public class ApplicationDetailDTO {

	private Long applicationId;
	private String applicationStatus;
	private String jobTitle;
	private String jobSeekerFullName;

	// Constructor matching the JPQL query
	public ApplicationDetailDTO(Long applicationId, String applicationStatus, String jobTitle,
			String jobSeekerFullName) {
		this.applicationId = applicationId;
		this.applicationStatus = applicationStatus;
		this.jobTitle = jobTitle;
		this.jobSeekerFullName = jobSeekerFullName;
	}

	// Getters and Setters
	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobSeekerFullName() {
		return jobSeekerFullName;
	}

	public void setJobSeekerFullName(String jobSeekerFullName) {
		this.jobSeekerFullName = jobSeekerFullName;
	}

	@Override
	public String toString() {
		return "ApplicationDetailDTO{" + "applicationId=" + applicationId + ", applicationStatus='" + applicationStatus
				+ '\'' + ", jobTitle='" + jobTitle + '\'' + ", jobSeekerFullName='" + jobSeekerFullName + '\'' + '}';
	}
}