package com.skillgap.skillgap_navigator.dto;

import java.util.List;

public class UserDTO {

    private Long id;
    private String name;
    private List<Long> skillIds;

    public UserDTO() {}

    public UserDTO(Long id, String name, List<Long> skillIds) {
        this.id = id;
        this.name = name;
        this.skillIds = skillIds;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Long> getSkillIds() {
        return skillIds;
    }
}
