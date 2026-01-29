package com.skillgap.skillgap_navigator.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillgap.skillgap_navigator.entity.PathStatus;
import com.skillgap.skillgap_navigator.entity.UserLearningPath;

public interface UserLearningPathRepository
        extends JpaRepository<UserLearningPath, Long> {

    List<UserLearningPath> findByUserId(Long userId);

    Optional<UserLearningPath> findByUserIdAndStatus(Long userId, PathStatus status);
}
