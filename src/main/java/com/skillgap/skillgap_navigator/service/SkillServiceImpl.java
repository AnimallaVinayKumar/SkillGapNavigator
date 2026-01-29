package com.skillgap.skillgap_navigator.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.skillgap.skillgap_navigator.dto.SkillDTO;
import com.skillgap.skillgap_navigator.entity.Skill;
import com.skillgap.skillgap_navigator.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public List<SkillDTO> getAllSkills() {
        List<Skill> skills = skillRepository.findAll();
        return skills.stream()
                .map(skill -> new SkillDTO(
                        skill.getId(),
                        skill.getName(),
                        skill.getCategory()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public SkillDTO createSkill(SkillDTO skillDTO) {
        // Convert DTO → Entity
        Skill skill = new Skill(skillDTO.getName(), skillDTO.getCategory());
        Skill savedSkill = skillRepository.save(skill);

        // Convert Entity → DTO
        return new SkillDTO(savedSkill.getId(), savedSkill.getName(), savedSkill.getCategory());
    }
}
