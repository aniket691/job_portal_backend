package com.app.service;

import com.app.dto.SkillDTO;
import java.util.List;

public interface SkillService {
    SkillDTO createSkill(SkillDTO skillDTO);
    SkillDTO getSkillById(Long skillId);
    List<SkillDTO> getAllSkills();
    SkillDTO updateSkill(Long skillId, SkillDTO skillDTO);
    void deleteSkill(Long skillId);
}
