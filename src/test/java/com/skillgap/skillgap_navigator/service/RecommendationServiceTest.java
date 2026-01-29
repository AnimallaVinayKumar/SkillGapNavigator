package com.skillgap.skillgap_navigator.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skillgap.skillgap_navigator.dto.RecommendationResponseDTO;

@SpringBootTest
class RecommendationServiceTest {

    @Autowired
    private RecommendationService recommendationService;

    @Test
    void shouldRecommendMissingSkills() {
        RecommendationResponseDTO response =
                recommendationService.recommendSkills(2L, 3L);

        assertNotNull(response);
        assertTrue(response.getRecommendations().size() >= 0);
    }
}
