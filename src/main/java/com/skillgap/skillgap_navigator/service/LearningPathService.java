package com.skillgap.skillgap_navigator.service;

import java.util.List;

import com.skillgap.skillgap_navigator.dto.CreateLearningPathRequest;
import com.skillgap.skillgap_navigator.dto.LearningPathDTO;

public interface LearningPathService {

    LearningPathDTO createLearningPath(CreateLearningPathRequest request);

    List<LearningPathDTO> getAllLearningPaths();

    List<LearningPathDTO> getLearningPathsForUser(Long userId);

    LearningPathDTO getLearningPathById(Long id);
}
