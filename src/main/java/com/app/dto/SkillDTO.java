package com.app.dto;

public class SkillDTO {

	private Long skillId;
	private String skillName;

	// Constructors
	public SkillDTO() {
	}

	public SkillDTO(Long skillId, String skillName) {
		this.skillId = skillId;
		this.skillName = skillName;
	}

	// Getters and Setters
	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
}
