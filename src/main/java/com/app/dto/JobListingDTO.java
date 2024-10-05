package com.app.dto;

public class JobListingDTO {

    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private String recruiterName; // Changed from recruiterId
    private String skillName;     // Changed from skillId

    // Constructors
    public JobListingDTO() {
    }

    public JobListingDTO(Long jobId, String jobTitle, String jobDescription, String recruiterName, String skillName) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.recruiterName = recruiterName;
        this.skillName = skillName;
    }

    // Getters and Setters
    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getRecruiterName() {
        return recruiterName;
    }

    public void setRecruiterName(String recruiterName) {
        this.recruiterName = recruiterName;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
