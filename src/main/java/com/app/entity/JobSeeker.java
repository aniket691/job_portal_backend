package com.app.entity;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "job_seekers")
public class JobSeeker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jobseeker_id")
	private Long jobSeekerId;

	@NotBlank(message = "Job seeker full name cannot be blank")
	@Column(name = "jobseeker_fullname", nullable = false)
	private String jobSeekerFullName;

	@Column(name = "jobseeker_mobilenumber")
	private String jobSeekerMobileNumber;

	@Column(name = "jobseeker_profilesummary")
	private String jobSeekerProfileSummary;

	@Column(name = "jobseeker_experience")
	private Long jobSeekerExperience;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resume_id", referencedColumnName = "id") // Foreign key column name
	private ImageData jobSeekerResume;

	@Column(name = "jobseeker_email")
	private String jobSeekerEmail;

	@Column(name = "jobseeker_password")
	private String jobSeekerPassword;

	@Column(name = "jobseeker_location")
	private String location; // New field for location

	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "subscription_id", unique = true)
	private Subscription subscription;

	public Long getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(Long jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public String getJobSeekerFullName() {
		return jobSeekerFullName;
	}

	public void setJobSeekerFullName(String jobSeekerFullName) {
		this.jobSeekerFullName = jobSeekerFullName;
	}

	public String getJobSeekerMobileNumber() {
		return jobSeekerMobileNumber;
	}

	public void setJobSeekerMobileNumber(String jobSeekerMobileNumber) {
		this.jobSeekerMobileNumber = jobSeekerMobileNumber;
	}

	public String getJobSeekerProfileSummary() {
		return jobSeekerProfileSummary;
	}

	public void setJobSeekerProfileSummary(String jobSeekerProfileSummary) {
		this.jobSeekerProfileSummary = jobSeekerProfileSummary;
	}

	public Long getJobSeekerExperience() {
		return jobSeekerExperience;
	}

	public void setJobSeekerExperience(Long jobSeekerExperience) {
		this.jobSeekerExperience = jobSeekerExperience;
	}

	public ImageData getJobSeekerResume() {
		return jobSeekerResume;
	}

	public void setJobSeekerResume(ImageData jobSeekerResume) {
		this.jobSeekerResume = jobSeekerResume;
	}

	public String getJobSeekerEmail() {
		return jobSeekerEmail;
	}

	public void setJobSeekerEmail(String jobSeekerEmail) {
		this.jobSeekerEmail = jobSeekerEmail;
	}

	public String getJobSeekerPassword() {
		return jobSeekerPassword;
	}

	public void setJobSeekerPassword(String jobSeekerPassword) {
		this.jobSeekerPassword = jobSeekerPassword;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

}
