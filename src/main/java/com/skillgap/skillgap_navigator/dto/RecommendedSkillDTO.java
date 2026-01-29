package com.skillgap.skillgap_navigator.dto;

public class RecommendedSkillDTO {

    private Long skillId;
    private String skillName;
    private String category;

    public RecommendedSkillDTO(Long skillId, String skillName, String category) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.category = category;
    }

    public Long getSkillId() {
        return skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public String getCategory() {
        return category;
    }
}
