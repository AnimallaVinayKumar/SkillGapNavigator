package com.skillgap.skillgap_navigator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillgap.skillgap_navigator.entity.LearningPath;

public interface LearningPathRepository extends JpaRepository<LearningPath, Long> {
}
