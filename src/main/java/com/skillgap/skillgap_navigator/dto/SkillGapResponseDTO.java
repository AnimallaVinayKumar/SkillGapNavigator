package com.skillgap.skillgap_navigator.dto;

import java.util.List;

public class SkillGapResponseDTO {

    private String userName;
    private String learningPathName;
    private List<String> knownSkills;
    private List<SkillGapExplanationDTO> explanations;
    private int gapPercentage;

    // ✅ THIS CONSTRUCTOR MUST EXIST
    public SkillGapResponseDTO(
            String userName,
            String learningPathName,
            List<String> knownSkills,
            List<SkillGapExplanationDTO> explanations,
            int gapPercentage) {

        this.userName = userName;
        this.learningPathName = learningPathName;
        this.knownSkills = knownSkills;
        this.explanations = explanations;
        this.gapPercentage = gapPercentage;
    }

    public String getUserName() {
        return userName;
    }

    public String getLearningPathName() {
        return learningPathName;
    }

    public List<String> getKnownSkills() {
        return knownSkills;
    }

    public List<SkillGapExplanationDTO> getExplanations() {
        return explanations;
    }

    public int getGapPercentage() {
        return gapPercentage;
    }
}
