package com.app.dto;

public class RecruiterDTO {

    private Long recruiterId;
    private String companyName;
    private String recruiterEmail;
    private String recruiterPassword;
    private String companyLocation;
    private String companyIndustry;
    private String companyWebsite;

    // Constructors
    public RecruiterDTO() {}

    public RecruiterDTO(Long recruiterId, String companyName, String recruiterEmail, String recruiterPassword, 
                        String companyLocation, String companyIndustry, String companyWebsite) {
        this.recruiterId = recruiterId;
        this.companyName = companyName;
        this.recruiterEmail = recruiterEmail;
        this.recruiterPassword = recruiterPassword;
        this.companyLocation = companyLocation;
        this.companyIndustry = companyIndustry;
        this.companyWebsite = companyWebsite;
    }

    // Getters and Setters
    public Long getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(Long recruiterId) {
        this.recruiterId = recruiterId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRecruiterEmail() {
        return recruiterEmail;
    }

    public void setRecruiterEmail(String recruiterEmail) {
        this.recruiterEmail = recruiterEmail;
    }

    public String getRecruiterPassword() {
        return recruiterPassword;
    }

    public void setRecruiterPassword(String recruiterPassword) {
        this.recruiterPassword = recruiterPassword;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public String getCompanyIndustry() {
        return companyIndustry;
    }

    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }
}
