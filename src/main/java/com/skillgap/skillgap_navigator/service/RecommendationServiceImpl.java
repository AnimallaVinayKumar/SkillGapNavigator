package com.skillgap.skillgap_navigator.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.skillgap.skillgap_navigator.dto.RecommendationResponseDTO;
import com.skillgap.skillgap_navigator.dto.RecommendedSkillDTO;
import com.skillgap.skillgap_navigator.entity.LearningPath;
import com.skillgap.skillgap_navigator.entity.Skill;
import com.skillgap.skillgap_navigator.entity.SkillStatus;
import com.skillgap.skillgap_navigator.entity.User;
import com.skillgap.skillgap_navigator.repository.LearningPathRepository;
import com.skillgap.skillgap_navigator.repository.UserRepository;
import com.skillgap.skillgap_navigator.repository.UserSkillProgressRepository;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final UserRepository userRepository;
    private final LearningPathRepository learningPathRepository;
    private final UserSkillProgressRepository progressRepository;

    public RecommendationServiceImpl(
            UserRepository userRepository,
            LearningPathRepository learningPathRepository,
            UserSkillProgressRepository progressRepository) {

        this.userRepository = userRepository;
        this.learningPathRepository = learningPathRepository;
        this.progressRepository = progressRepository;
    }

    @Override
    public RecommendationResponseDTO recommendSkills(Long userId, Long pathId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        LearningPath path = learningPathRepository.findById(pathId)
                .orElseThrow(() -> new RuntimeException("Learning path not found"));

        Set<Long> completedSkillIds =
                progressRepository.findByUserId(userId).stream()
                        .filter(p -> p.getStatus() == SkillStatus.COMPLETED)
                        .map(p -> p.getSkill().getId())
                        .collect(Collectors.toSet());

        List<RecommendedSkillDTO> recommendations =
                path.getSkills().stream()
                        .filter(skill -> !completedSkillIds.contains(skill.getId()))
                        .map(skill -> new RecommendedSkillDTO(
                                skill.getId(),
                                skill.getName(),
                                skill.getCategory()
                                ))
                        .toList();

        return new RecommendationResponseDTO(
                user.getName(),
                path.getName(),
                recommendations
        );
    }

}
