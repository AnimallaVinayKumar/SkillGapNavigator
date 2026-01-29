package com.skillgap.skillgap_navigator.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.skillgap.skillgap_navigator.dto.SkillGapExplanationDTO;
import com.skillgap.skillgap_navigator.dto.SkillGapResponseDTO;
import com.skillgap.skillgap_navigator.entity.LearningPath;
import com.skillgap.skillgap_navigator.entity.Skill;
import com.skillgap.skillgap_navigator.entity.SkillStatus;
import com.skillgap.skillgap_navigator.entity.User;
import com.skillgap.skillgap_navigator.repository.LearningPathRepository;
import com.skillgap.skillgap_navigator.repository.UserRepository;
import com.skillgap.skillgap_navigator.repository.UserSkillProgressRepository;

@Service
public class SkillGapServiceImpl implements SkillGapService {

    private final UserRepository userRepository;
    private final LearningPathRepository learningPathRepository;
    private final UserSkillProgressRepository progressRepository;

    public SkillGapServiceImpl(
            UserRepository userRepository,
            LearningPathRepository learningPathRepository,
            UserSkillProgressRepository progressRepository) {

        this.userRepository = userRepository;
        this.learningPathRepository = learningPathRepository;
        this.progressRepository = progressRepository;
    }

    @Override
    public SkillGapResponseDTO calculateSkillGap(Long userId, Long pathId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        LearningPath path = learningPathRepository.findById(pathId)
                .orElseThrow(() -> new RuntimeException("Learning path not found"));

        // ===== COMPLETED SKILLS =====
        Set<Long> completedSkillIds =
                progressRepository.findByUserId(userId).stream()
                        .filter(p -> p.getStatus() == SkillStatus.COMPLETED)
                        .map(p -> p.getSkill().getId())
                        .collect(Collectors.toSet());

        List<String> knownSkills =
                path.getSkills().stream()
                        .filter(skill -> completedSkillIds.contains(skill.getId()))
                        .map(Skill::getName)
                        .collect(Collectors.toList());

        // ===== FEATURE-5: EXPLANATIONS FOR MISSING / INCOMPLETE =====
        List<SkillGapExplanationDTO> explanations =
                path.getSkills().stream()
                        .filter(skill -> !completedSkillIds.contains(skill.getId()))
                        .map(skill -> new SkillGapExplanationDTO(
                                skill.getName(),
                                skill.getCategory(),
                                explainSkill(skill.getName())
                        ))
                        .collect(Collectors.toList());

        // ===== FEATURE-6: WEIGHTED GAP CALCULATION =====
        int totalWeight = 0;

        for (Skill skill : path.getSkills()) {
            SkillStatus status =
                    progressRepository
                            .findByUserIdAndSkillId(userId, skill.getId())
                            .map(p -> p.getStatus())
                            .orElse(SkillStatus.NOT_STARTED);

            totalWeight += statusWeight(status);
        }

        int gapPercentage =
                path.getSkills().isEmpty()
                        ? 0
                        : totalWeight / path.getSkills().size();

        return new SkillGapResponseDTO(
                user.getName(),
                path.getName(),
                knownSkills,
                explanations,
                gapPercentage
        );
    }

    // ===== GAP WEIGHTING =====
    private int statusWeight(SkillStatus status) {
        return switch (status) {
            case COMPLETED -> 0;
            case IN_PROGRESS -> 50;
            case NOT_STARTED -> 100;
        };
    }

    // ===== SKILL EXPLANATIONS =====
    private String explainSkill(String skillName) {
        return switch (skillName.toLowerCase()) {
            case "java" ->
                "Java is the foundation of backend development and is required for building scalable server-side applications.";
            case "spring boot" ->
                "Spring Boot is essential for building REST APIs and production-ready backend services.";
            case "mysql" ->
                "MySQL is required to persist and manage relational data in backend systems.";
            case "docker" ->
                "Docker enables containerization, which is essential for deployment and DevOps workflows.";
            case "react" ->
                "React is used to build interactive user interfaces that consume backend APIs.";
            default ->
                "This skill is required to meet modern industry standards for the selected role.";
        };
    }
}
