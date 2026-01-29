package com.skillgap.skillgap_navigator.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "user_learning_progress")
public class UserLearningProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long learningPathId;

    private int completedSkills;
    private int totalSkills;

    public int getProgressPercentage() {
        if (totalSkills == 0) return 0;
        return (completedSkills * 100) / totalSkills;
    }

    // getters and setters
}
