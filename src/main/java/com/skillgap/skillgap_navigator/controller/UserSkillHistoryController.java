package com.skillgap.skillgap_navigator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillgap.skillgap_navigator.dto.UserSkillHistoryDTO;
import com.skillgap.skillgap_navigator.repository.UserSkillProgressRepository;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserSkillHistoryController {

    private final UserSkillProgressRepository progressRepository;

    public UserSkillHistoryController(UserSkillProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    @GetMapping("/{userId}/skill-history")
    public List<UserSkillHistoryDTO> getSkillHistory(@PathVariable Long userId) {

        return progressRepository.findByUserId(userId).stream()
                .map(p -> new UserSkillHistoryDTO(
                        p.getSkill().getId(),
                        p.getSkill().getName(),
                        p.getStatus(),
                        p.getStartedAt(),
                        p.getCompletedAt(),
                        p.getResourceUsed()
                ))
                .toList();
    }
}
