package com.skillgap.skillgap_navigator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillgap.skillgap_navigator.entity.PathStatus;
import com.skillgap.skillgap_navigator.entity.UserLearningPath;
import com.skillgap.skillgap_navigator.repository.UserLearningPathRepository;

@Service
public class UserLearningPathServiceImpl implements UserLearningPathService {

    private final UserLearningPathRepository repo;

    public UserLearningPathServiceImpl(UserLearningPathRepository repo) {
        this.repo = repo;
    }

    @Override
    public void addPath(Long userId, Long pathId) {
        UserLearningPath ulp = new UserLearningPath();
        ulp.setUserId(userId);
        ulp.setLearningPathId(pathId);
        ulp.setStatus(PathStatus.SAVED);
        repo.save(ulp);
    }

    @Override
    public void setActivePath(Long userId, Long pathId) {

        repo.findByUserIdAndStatus(userId, PathStatus.ACTIVE)
                .ifPresent(p -> {
                    p.setStatus(PathStatus.SAVED);
                    repo.save(p);
                });

        UserLearningPath target = repo.findByUserId(userId)
                .stream()
                .filter(p -> p.getLearningPathId().equals(pathId))
                .findFirst()
                .orElseThrow();

        target.setStatus(PathStatus.ACTIVE);
        repo.save(target);
    }

    @Override
    public List<UserLearningPath> getUserPaths(Long userId) {
        return repo.findByUserId(userId);
    }
}
