package com.skillgap.skillgap_navigator.repository;

import com.skillgap.skillgap_navigator.entity.UserLearningProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLearningProgressRepository
        extends JpaRepository<UserLearningProgress, Long> {

    Optional<UserLearningProgress> findByUserIdAndLearningPathId(
            Long userId, Long learningPathId);
}
