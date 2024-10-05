package com.app.services.impl;

import com.app.dto.SkillDTO;
import com.app.entity.Skill;
import com.app.repository.SkillRepository;
import com.app.service.SkillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SkillDTO createSkill(SkillDTO skillDTO) {
        Skill skill = modelMapper.map(skillDTO, Skill.class);
        Skill savedSkill = skillRepository.save(skill);
        return modelMapper.map(savedSkill, SkillDTO.class);
    }

    @Override
    public SkillDTO getSkillById(Long skillId) {
        Skill skill = skillRepository.findById(skillId).orElseThrow(() -> new EntityNotFoundException("Skill not found"));
        return modelMapper.map(skill, SkillDTO.class);
    }

    @Override
    public List<SkillDTO> getAllSkills() {
        List<Skill> skills = skillRepository.findAll();
        return skills.stream().map(skill -> modelMapper.map(skill, SkillDTO.class)).collect(Collectors.toList());
    }

    @Override
    public SkillDTO updateSkill(Long skillId, SkillDTO skillDTO) {
        Skill skill = skillRepository.findById(skillId).orElseThrow(() -> new EntityNotFoundException("Skill not found"));
        skill.setSkillName(skillDTO.getSkillName());
        Skill updatedSkill = skillRepository.save(skill);
        return modelMapper.map(updatedSkill, SkillDTO.class);
    }

    @Override
    public void deleteSkill(Long skillId) {
        Skill skill = skillRepository.findById(skillId).orElseThrow(() -> new EntityNotFoundException("Skill not found"));
        skillRepository.delete(skill);
    }
}
