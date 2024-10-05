package com.app.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.RecruiterDTO;
import com.app.entity.Recruiter;
import com.app.repository.RecruiterRepository;
import com.app.service.RecruiterService;

@Service
public class RecruiterServiceImpl implements RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Override
    public RecruiterDTO createRecruiter(RecruiterDTO recruiterDTO) {
        Recruiter recruiter = new Recruiter(
                0,
                recruiterDTO.getCompanyName(),
                recruiterDTO.getRecruiterEmail(),
                recruiterDTO.getRecruiterPassword(),
                recruiterDTO.getCompanyLocation(),
                recruiterDTO.getCompanyIndustry(),
                recruiterDTO.getCompanyWebsite()
        );
        Recruiter savedRecruiter = recruiterRepository.save(recruiter);
        return convertToDTO(savedRecruiter);
    }

    @Override
    public RecruiterDTO getRecruiterById(long recruiterId) {
        Optional<Recruiter> recruiter = recruiterRepository.findById(recruiterId);
        return recruiter.map(this::convertToDTO).orElse(null);
    }

    @Override
    public List<RecruiterDTO> getAllRecruiters() {
        List<Recruiter> recruiters = recruiterRepository.findAll();
        return recruiters.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public RecruiterDTO updateRecruiter(long recruiterId, RecruiterDTO recruiterDTO) {
        Optional<Recruiter> recruiterOptional = recruiterRepository.findById(recruiterId);
        if (recruiterOptional.isPresent()) {
            Recruiter recruiter = recruiterOptional.get();
            recruiter.setCompanyName(recruiterDTO.getCompanyName());
            recruiter.setRecruiterEmail(recruiterDTO.getRecruiterEmail());
            recruiter.setRecruiterPassword(recruiterDTO.getRecruiterPassword());
            recruiter.setCompanyLocation(recruiterDTO.getCompanyLocation());
            recruiter.setCompanyIndustry(recruiterDTO.getCompanyIndustry());
            recruiter.setCompanyWebsite(recruiterDTO.getCompanyWebsite());
            Recruiter updatedRecruiter = recruiterRepository.save(recruiter);
            return convertToDTO(updatedRecruiter);
        }
        return null;
    }

    @Override
    public void deleteRecruiter(long recruiterId) {
        recruiterRepository.deleteById(recruiterId);
    }
    
    

    private RecruiterDTO convertToDTO(Recruiter recruiter) {
        return new RecruiterDTO(
                recruiter.getRecruiterId(),
                recruiter.getCompanyName(),
                recruiter.getRecruiterEmail(),
                recruiter.getRecruiterPassword(),
                recruiter.getCompanyLocation(),
                recruiter.getCompanyIndustry(),
                recruiter.getCompanyWebsite()
        );
    }

	@Override
	public Optional<Recruiter> login(String email, String password) {
		return recruiterRepository.findByRecruiterEmailAndRecruiterPassword(email, password);
	}
    
    
    
    
}
