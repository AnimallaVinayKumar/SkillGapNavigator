package com.skillgap.skillgap_navigator.dto;

import java.util.List;

public class LearningPathDTO {

    private Long id;
    private String name;
    private List<SkillDTO> skills;

    public LearningPathDTO() {}

    public LearningPathDTO(Long id, String name, List<SkillDTO> skills) {
        this.id = id;
        this.name = name;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SkillDTO> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillDTO> skills) {
        this.skills = skills;
    }
}
