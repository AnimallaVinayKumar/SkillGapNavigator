package com.skillgap.skillgap_navigator.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_learning_paths")
public class UserLearningPath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long learningPathId;

    @Enumerated(EnumType.STRING)
    private PathStatus status;

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Long getLearningPathId() { return learningPathId; }
    public PathStatus getStatus() { return status; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setLearningPathId(Long learningPathId) { this.learningPathId = learningPathId; }
    public void setStatus(PathStatus status) { this.status = status; }
}
