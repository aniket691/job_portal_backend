package com.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "recruiters")
public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruiter_id")
    private long recruiterId;

    @NotBlank(message = "company name can not be blank")
    @Column(name = "company_name", nullable = false)
    private String companyName;

    @NotBlank(message = "recruiter email can not be blank")
    @Column(name = "recruiter_email", nullable = false)
    private String recruiterEmail;

    @NotBlank(message = "recruiter password can not be blank")
    @Column(name = "recruiter_password", nullable = false)
    private String recruiterPassword;

    @NotBlank(message = "company location can not be blank")
    @Column(name = "company_location", nullable = false)
    private String companyLocation;

    @NotBlank(message = "company industry can not be blank")
    @Column(name = "company_industry", nullable = false)
    private String companyIndustry;

    @NotBlank(message = "company website can not be blank")
    @Column(name = "company_website", nullable = false)
    private String companyWebsite;

    // Constructors
    public Recruiter(long recruiterId, @NotBlank(message = "company name can not be blank") String companyName,
                     @NotBlank(message = "recruiter email can not be blank") String recruiterEmail,
                     @NotBlank(message = "recruiter password can not be blank") String recruiterPassword,
                     @NotBlank(message = "company location can not be blank") String companyLocation,
                     @NotBlank(message = "company industry can not be blank") String companyIndustry,
                     @NotBlank(message = "company website can not be blank") String companyWebsite) {
        super();
        this.recruiterId = recruiterId;
        this.companyName = companyName;
        this.recruiterEmail = recruiterEmail;
        this.recruiterPassword = recruiterPassword;
        this.companyLocation = companyLocation;
        this.companyIndustry = companyIndustry;
        this.companyWebsite = companyWebsite;
    }

    public Recruiter() {
        super();
    }

    // Getters and Setters
    public long getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(long recruiterId) {
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

    @Override
    public String toString() {
        return "Recruiter{" +
                "recruiterId=" + recruiterId +
                ", companyName='" + companyName + '\'' +
                ", recruiterEmail='" + recruiterEmail + '\'' +
                ", recruiterPassword='" + recruiterPassword + '\'' +
                ", companyLocation='" + companyLocation + '\'' +
                ", companyIndustry='" + companyIndustry + '\'' +
                ", companyWebsite='" + companyWebsite + '\'' +
                '}';
    }
}
