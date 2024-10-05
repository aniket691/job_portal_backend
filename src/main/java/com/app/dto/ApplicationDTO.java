package com.app.dto;

public class ApplicationDTO {

    private Long applicationId;
    private String applicationStatus;
    private Long jobSeekerId;
    private Long jobId;

    // Constructors
    public ApplicationDTO() {}

    public ApplicationDTO(Long applicationId, String applicationStatus, Long jobSeekerId, Long jobId) {
        this.applicationId = applicationId;
        this.applicationStatus = applicationStatus;
        this.jobSeekerId = jobSeekerId;
        this.jobId = jobId;
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

    public Long getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(Long jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
}
