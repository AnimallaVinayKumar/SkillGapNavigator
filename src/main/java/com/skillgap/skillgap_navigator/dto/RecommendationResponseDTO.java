package com.skillgap.skillgap_navigator.dto;

import java.util.List;

public class RecommendationResponseDTO {

    private String userName;
    private String learningPathName;
    private List<RecommendedSkillDTO> recommendations;

    public RecommendationResponseDTO(
            String userName,
            String learningPathName,
            List<RecommendedSkillDTO> recommendations) {
        this.userName = userName;
        this.learningPathName = learningPathName;
        this.recommendations = recommendations;
    }

    public String getUserName() {
        return userName;
    }

    public String getLearningPathName() {
        return learningPathName;
    }

    public List<RecommendedSkillDTO> getRecommendations() {
        return recommendations;
    }
}
