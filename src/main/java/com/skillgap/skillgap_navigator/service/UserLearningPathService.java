package com.skillgap.skillgap_navigator.service;

import java.util.List;

import com.skillgap.skillgap_navigator.entity.UserLearningPath;

public interface UserLearningPathService {

    void addPath(Long userId, Long pathId);

    void setActivePath(Long userId, Long pathId);

    List<UserLearningPath> getUserPaths(Long userId);
}
