package com.skillgap.skillgap_navigator.dto;

import com.skillgap.skillgap_navigator.entity.ResourceType;

public class SkillResourceDTO {

    private ResourceType type;
    private String url;

    public SkillResourceDTO(ResourceType type, String url) {
        this.type = type;
        this.url = url;
    }

    public ResourceType getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }
}
