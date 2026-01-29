package com.skillgap.skillgap_navigator.dto;

public class ProgressResponseDTO {

    private Long userId;
    private Long learningPathId;
    private int totalSkills;
    private int completedSkills;
    private int gapPercentage;

    public ProgressResponseDTO(Long userId, Long learningPathId,
                               int totalSkills, int completedSkills,
                               int gapPercentage) {
        this.userId = userId;
        this.learningPathId = learningPathId;
        this.totalSkills = totalSkills;
        this.completedSkills = completedSkills;
        this.gapPercentage = gapPercentage;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getLearningPathId() {
        return learningPathId;
    }

    public int getTotalSkills() {
        return totalSkills;
    }

    public int getCompletedSkills() {
        return completedSkills;
    }

    public int getGapPercentage() {
        return gapPercentage;
    }
}