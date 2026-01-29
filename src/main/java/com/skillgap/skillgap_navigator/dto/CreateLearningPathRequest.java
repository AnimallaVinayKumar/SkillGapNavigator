package com.skillgap.skillgap_navigator.dto;

import java.util.List;

public class CreateLearningPathRequest {

    private String name;
    private List<Long> skillIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getSkillIds() {
        return skillIds;
    }

    public void setSkillIds(List<Long> skillIds) {
        this.skillIds = skillIds;
    }
}
