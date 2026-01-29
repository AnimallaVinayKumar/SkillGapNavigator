package com.skillgap.skillgap_navigator.dto;

import com.skillgap.skillgap_navigator.entity.SkillStatus;

public class SkillProgressRequestDTO {

    private SkillStatus status;

    public SkillStatus getStatus() {
        return status;
    }

    public void setStatus(SkillStatus status) {
        this.status = status;
    }
}
