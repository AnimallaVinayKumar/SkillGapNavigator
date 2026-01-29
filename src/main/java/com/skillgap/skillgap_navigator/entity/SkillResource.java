package com.skillgap.skillgap_navigator.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "skill_resources")
public class SkillResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @Enumerated(EnumType.STRING)
    private ResourceType type;

    private String url;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public Skill getSkill() {
        return skill;
    }

    public ResourceType getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
