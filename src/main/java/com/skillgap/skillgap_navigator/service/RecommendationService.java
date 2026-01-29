package com.skillgap.skillgap_navigator.service;

import com.skillgap.skillgap_navigator.dto.RecommendationResponseDTO;

public interface RecommendationService {

    RecommendationResponseDTO recommendSkills(Long userId, Long pathId);
}
