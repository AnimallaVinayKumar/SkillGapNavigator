package com.skillgap.skillgap_navigator.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.skillgap.skillgap_navigator.entity.Skill;
import com.skillgap.skillgap_navigator.entity.SkillStatus;
import com.skillgap.skillgap_navigator.entity.User;
import com.skillgap.skillgap_navigator.entity.UserSkillProgress;
import com.skillgap.skillgap_navigator.repository.SkillRepository;
import com.skillgap.skillgap_navigator.repository.UserRepository;
import com.skillgap.skillgap_navigator.repository.UserSkillProgressRepository;

@Service
public class UserSkillProgressServiceImpl implements UserSkillProgressService {

    private final UserSkillProgressRepository progressRepository;
    private final UserRepository userRepository;
    private final SkillRepository skillRepository;

    public UserSkillProgressServiceImpl(
            UserSkillProgressRepository progressRepository,
            UserRepository userRepository,
            SkillRepository skillRepository) {

        this.progressRepository = progressRepository;
        this.userRepository = userRepository;
        this.skillRepository = skillRepository;
    }

    @Override
public void updateProgress(Long userId, Long skillId, SkillStatus status) {

    User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

    Skill skill = skillRepository.findById(skillId)
            .orElseThrow(() -> new RuntimeException("Skill not found"));

    UserSkillProgress progress =
            progressRepository.findByUserIdAndSkillId(userId, skillId)
                    .orElse(new UserSkillProgress(user, skill));

    if (status == SkillStatus.IN_PROGRESS && progress.getStartedAt() == null) {
        progress.setStartedAt(LocalDateTime.now());
    }

    if (status == SkillStatus.COMPLETED) {
        progress.setCompletedAt(LocalDateTime.now());
    }

    progress.setStatus(status);
    progressRepository.save(progress);
}

}
