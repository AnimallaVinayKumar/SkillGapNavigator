package com.skillgap.skillgap_navigator.service;

import com.skillgap.skillgap_navigator.entity.SkillStatus;

public interface UserSkillProgressService {
    void updateProgress(Long userId, Long skillId, SkillStatus status);
}
