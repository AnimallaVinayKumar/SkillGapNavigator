package com.skillgap.skillgap_navigator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillgap.skillgap_navigator.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    // You can add custom queries here if needed
}
