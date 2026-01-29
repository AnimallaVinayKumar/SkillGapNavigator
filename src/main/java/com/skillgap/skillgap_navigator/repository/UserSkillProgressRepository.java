package com.skillgap.skillgap_navigator.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillgap.skillgap_navigator.entity.UserSkillProgress;

public interface UserSkillProgressRepository
        extends JpaRepository<UserSkillProgress, Long> {

    List<UserSkillProgress> findByUserId(Long userId);

    //Optional<UserSkillProgress> findByUserIdAndSkillId(Long userId, Long skillId);
    Optional<UserSkillProgress> findByUserIdAndSkillId(Long userId, Long skillId);

}
