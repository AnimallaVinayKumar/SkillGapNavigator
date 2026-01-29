package com.skillgap.skillgap_navigator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillgap.skillgap_navigator.entity.UserLearningPath;
import com.skillgap.skillgap_navigator.service.UserLearningPathService;

@RestController
@RequestMapping("/api/users/{userId}/paths")
@CrossOrigin(origins = "http://localhost:3000")
public class UserLearningPathController {

    private final UserLearningPathService service;

    public UserLearningPathController(UserLearningPathService service) {
        this.service = service;
    }

    @PostMapping("/{pathId}")
    public void addPath(@PathVariable Long userId,
                        @PathVariable Long pathId) {
        service.addPath(userId, pathId);
    }

    @PutMapping("/{pathId}/activate")
    public void activate(@PathVariable Long userId,
                         @PathVariable Long pathId) {
        service.setActivePath(userId, pathId);
    }

    @GetMapping
    public List<UserLearningPath> getPaths(@PathVariable Long userId) {
        return service.getUserPaths(userId);
    }
}
