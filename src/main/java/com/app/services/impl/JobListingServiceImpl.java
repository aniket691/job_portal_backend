package com.app.services.impl;

import com.app.dto.JobListingDTO;
import com.app.entity.JobListing;
import com.app.entity.Recruiter;
import com.app.entity.Skill;
import com.app.repository.JobListingRepository;
import com.app.repository.RecruiterRepository;
import com.app.repository.SkillRepository;
import com.app.service.JobListingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobListingServiceImpl implements JobListingService {

    @Autowired
    private JobListingRepository jobListingRepository;

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostConstruct
    public void setupModelMapper() {
        modelMapper.typeMap(JobListing.class, JobListingDTO.class).addMappings(mapper -> {
            mapper.map(src -> src.getSkill().getSkillName(), JobListingDTO::setSkillName);
            mapper.map(src -> src.getRecruiter().getRecruiterEmail(), JobListingDTO::setRecruiterName);
        });
    }

    @Override
    public JobListingDTO createJobListing(JobListingDTO jobListingDTO) {
        JobListing jobListing = modelMapper.map(jobListingDTO, JobListing.class);

        // Convert recruiterName to recruiterId and set it to the jobListing
        Recruiter recruiter = recruiterRepository.findByRecruiterEmail(jobListingDTO.getRecruiterName())
                .orElseThrow(() -> new EntityNotFoundException("Recruiter not found"));
        jobListing.setRecruiter(recruiter);

        // Convert skillName to skillId and set it to the jobListing
        Skill skill = skillRepository.findBySkillName(jobListingDTO.getSkillName())
                .orElseThrow(() -> new EntityNotFoundException("Skill not found"));
        jobListing.setSkill(skill);

        JobListing savedJobListing = jobListingRepository.save(jobListing);
        return modelMapper.map(savedJobListing, JobListingDTO.class);
    }

    @Override
    public JobListingDTO getJobListingById(Long jobId) {
        JobListing jobListing = jobListingRepository.findById(jobId)
                .orElseThrow(() -> new EntityNotFoundException("JobListing not found"));
        return modelMapper.map(jobListing, JobListingDTO.class);
    }

    @Override
    public List<JobListingDTO> getAllJobListings() {
        List<JobListing> jobListings = jobListingRepository.findAll();
        return jobListings.stream()
                .map(jobListing -> modelMapper.map(jobListing, JobListingDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public JobListingDTO updateJobListing(Long jobId, JobListingDTO jobListingDTO) {
        JobListing jobListing = jobListingRepository.findById(jobId)
                .orElseThrow(() -> new EntityNotFoundException("JobListing not found"));

        jobListing.setJobTitle(jobListingDTO.getJobTitle());
        jobListing.setJobDescription(jobListingDTO.getJobDescription());

        // Convert recruiterName to recruiterId and update the jobListing
        Recruiter recruiter = recruiterRepository.findByRecruiterEmail(jobListingDTO.getRecruiterName())
                .orElseThrow(() -> new EntityNotFoundException("Recruiter not found"));
        jobListing.setRecruiter(recruiter);

        // Convert skillName to skillId and update the jobListing
        Skill skill = skillRepository.findBySkillName(jobListingDTO.getSkillName())
                .orElseThrow(() -> new EntityNotFoundException("Skill not found"));
        jobListing.setSkill(skill);

        JobListing updatedJobListing = jobListingRepository.save(jobListing);
        return modelMapper.map(updatedJobListing, JobListingDTO.class);
    }

    @Override
    public void deleteJobListing(Long jobId) {
        JobListing jobListing = jobListingRepository.findById(jobId)
                .orElseThrow(() -> new EntityNotFoundException("JobListing not found"));
        jobListingRepository.delete(jobListing);
    }
}
