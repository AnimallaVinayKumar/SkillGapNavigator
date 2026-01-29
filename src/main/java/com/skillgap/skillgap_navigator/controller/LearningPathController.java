package com.skillgap.skillgap_navigator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.skillgap.skillgap_navigator.dto.CreateLearningPathRequest;
import com.skillgap.skillgap_navigator.dto.LearningPathDTO;
import com.skillgap.skillgap_navigator.service.LearningPathService;

@RestController
@RequestMapping("/api/learning-paths")
@CrossOrigin(origins = "http://localhost:3000")
public class LearningPathController {

    private final LearningPathService learningPathService;

    public LearningPathController(LearningPathService learningPathService) {
        this.learningPathService = learningPathService;
    }

    @GetMapping
    public List<LearningPathDTO> getAll() {
        return learningPathService.getAllLearningPaths();
    }

    @GetMapping("/user/{userId}")
    public List<LearningPathDTO> getByUser(@PathVariable Long userId) {
        return learningPathService.getLearningPathsForUser(userId);
    }

    @GetMapping("/{id}")
    public LearningPathDTO getById(@PathVariable Long id) {
        return learningPathService.getLearningPathById(id);
    }

    @PostMapping
    public LearningPathDTO create(@RequestBody CreateLearningPathRequest request) {
        return learningPathService.createLearningPath(request);
    }
}
