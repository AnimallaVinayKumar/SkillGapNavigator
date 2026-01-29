package com.skillgap.skillgap_navigator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillgap.skillgap_navigator.dto.SkillGapResponseDTO;
import com.skillgap.skillgap_navigator.service.SkillGapService;

@RestController
@RequestMapping("/api/skill-gap")
@CrossOrigin(origins = "http://localhost:3000")
public class SkillGapController {

    private final SkillGapService skillGapService;

    public SkillGapController(SkillGapService skillGapService) {
        this.skillGapService = skillGapService;
    }

    @GetMapping("/{userId}/{pathId}")
    public ResponseEntity<SkillGapResponseDTO> getSkillGap(
            @PathVariable Long userId,
            @PathVariable Long pathId) {

        SkillGapResponseDTO response =
                skillGapService.calculateSkillGap(userId, pathId);

        return ResponseEntity.ok(response);
    }
}
