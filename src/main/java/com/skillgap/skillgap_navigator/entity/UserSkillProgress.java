package com.skillgap.skillgap_navigator.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_skill_progress")
public class UserSkillProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Enumerated(EnumType.STRING)
    private SkillStatus status;

    // ===== FEATURE-2: LEARNING HISTORY =====
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
    private String resourceUsed;

    // ===== CONSTRUCTORS =====
    public UserSkillProgress() {}

    public UserSkillProgress(User user, Skill skill) {
        this.user = user;
        this.skill = skill;
        this.status = SkillStatus.NOT_STARTED;
    }

    // ===== GETTERS & SETTERS =====
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Skill getSkill() {
        return skill;
    }

    public SkillStatus getStatus() {
        return status;
    }

    public void setStatus(SkillStatus status) {
        this.status = status;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public String getResourceUsed() {
        return resourceUsed;
    }

    public void setResourceUsed(String resourceUsed) {
        this.resourceUsed = resourceUsed;
    }
}
