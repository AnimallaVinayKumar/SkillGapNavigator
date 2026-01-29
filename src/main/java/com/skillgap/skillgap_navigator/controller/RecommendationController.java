package com.skillgap.skillgap_navigator.controller;

import com.skillgap.skillgap_navigator.dto.RecommendationResponseDTO;
import com.skillgap.skillgap_navigator.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendations")
@CrossOrigin(origins = "http://localhost:3000")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/{userId}/{pathId}")
    public RecommendationResponseDTO getRecommendations(
            @PathVariable Long userId,
            @PathVariable Long pathId) {

        return recommendationService.recommendSkills(userId, pathId);
    }
}
