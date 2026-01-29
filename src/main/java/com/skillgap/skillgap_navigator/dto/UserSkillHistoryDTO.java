package com.skillgap.skillgap_navigator.dto;

import java.time.LocalDateTime;

import com.skillgap.skillgap_navigator.entity.SkillStatus;

public class UserSkillHistoryDTO {

    private Long skillId;
    private String skillName;
    private SkillStatus status;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
    private String resourceUsed;

    public UserSkillHistoryDTO(
            Long skillId,
            String skillName,
            SkillStatus status,
            LocalDateTime startedAt,
            LocalDateTime completedAt,
            String resourceUsed) {

        this.skillId = skillId;
        this.skillName = skillName;
        this.status = status;
        this.startedAt = startedAt;
        this.completedAt = completedAt;
        this.resourceUsed = resourceUsed;
    }

    public Long getSkillId() { return skillId; }
    public String getSkillName() { return skillName; }
    public SkillStatus getStatus() { return status; }
    public LocalDateTime getStartedAt() { return startedAt; }
    public LocalDateTime getCompletedAt() { return completedAt; }
    public String getResourceUsed() { return resourceUsed; }
}
