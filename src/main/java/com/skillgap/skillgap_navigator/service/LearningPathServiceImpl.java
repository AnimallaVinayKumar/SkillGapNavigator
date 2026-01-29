package com.skillgap.skillgap_navigator.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.skillgap.skillgap_navigator.dto.CreateLearningPathRequest;
import com.skillgap.skillgap_navigator.dto.LearningPathDTO;
import com.skillgap.skillgap_navigator.dto.SkillDTO;
import com.skillgap.skillgap_navigator.entity.LearningPath;
import com.skillgap.skillgap_navigator.entity.Skill;
import com.skillgap.skillgap_navigator.repository.LearningPathRepository;
import com.skillgap.skillgap_navigator.repository.SkillRepository;

@Service
public class LearningPathServiceImpl implements LearningPathService {

    private final LearningPathRepository learningPathRepository;
    private final SkillRepository skillRepository;

    public LearningPathServiceImpl(
            LearningPathRepository learningPathRepository,
            SkillRepository skillRepository) {
        this.learningPathRepository = learningPathRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public LearningPathDTO createLearningPath(CreateLearningPathRequest request) {

        List<Skill> skills = skillRepository.findAllById(request.getSkillIds());

        LearningPath path = new LearningPath();
        path.setName(request.getName());
        path.setSkills(skills);

        LearningPath saved = learningPathRepository.save(path);
        return mapToDTO(saved);
    }

    @Override
    public List<LearningPathDTO> getAllLearningPaths() {
        return learningPathRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LearningPathDTO> getLearningPathsForUser(Long userId) {
        // until user-path mapping is enforced
        return getAllLearningPaths();
    }

    @Override
    public LearningPathDTO getLearningPathById(Long id) {
        LearningPath path = learningPathRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Learning path not found"));
        return mapToDTO(path);
    }

    private LearningPathDTO mapToDTO(LearningPath path) {

        List<SkillDTO> skills = path.getSkills()
                .stream()
                .map(s -> new SkillDTO(
                        s.getId(),
                        s.getName(),
                        s.getCategory()
                ))
                .collect(Collectors.toList());

        return new LearningPathDTO(
                path.getId(),
                path.getName(),
                skills
        );
    }
}
