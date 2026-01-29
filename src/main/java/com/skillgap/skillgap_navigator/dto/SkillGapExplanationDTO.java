package com.skillgap.skillgap_navigator.dto;

public class SkillGapExplanationDTO {

    private String skillName;
    private String category;
    private String explanation;

    public SkillGapExplanationDTO(String skillName, String category, String explanation) {
        this.skillName = skillName;
        this.category = category;
        this.explanation = explanation;
    }

    public String getSkillName() {
        return skillName;
    }

    public String getCategory() {
        return category;
    }

    public String getExplanation() {
        return explanation;
    }
}
