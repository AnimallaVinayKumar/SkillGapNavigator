package com.skillgap.skillgap_navigator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillgap.skillgap_navigator.entity.SkillResource;

public interface SkillResourceRepository
        extends JpaRepository<SkillResource, Long> {

    List<SkillResource> findBySkillId(Long skillId);
}
