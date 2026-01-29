package com.skillgap.skillgap_navigator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skillgap.skillgap_navigator.dto.SkillProgressRequestDTO;
import com.skillgap.skillgap_navigator.service.UserSkillProgressService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserSkillProgressController {

    private final UserSkillProgressService userSkillProgressService;

    public UserSkillProgressController(UserSkillProgressService userSkillProgressService) {
        this.userSkillProgressService = userSkillProgressService;
    }

    // ✅ CREATE or UPDATE skill progress
    @PutMapping("/{userId}/skills/{skillId}/progress")
    public ResponseEntity<Void> updateSkillProgress(
            @PathVariable Long userId,
            @PathVariable Long skillId,
            @RequestBody SkillProgressRequestDTO request) {

        userSkillProgressService.updateProgress(
                userId,
                skillId,
                request.getStatus()
        );

        return ResponseEntity.ok().build();
    }
}
