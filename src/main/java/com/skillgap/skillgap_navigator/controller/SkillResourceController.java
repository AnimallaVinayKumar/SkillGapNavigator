package com.skillgap.skillgap_navigator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.skillgap.skillgap_navigator.dto.SkillResourceDTO;
import com.skillgap.skillgap_navigator.repository.SkillResourceRepository;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "http://localhost:3000")
public class SkillResourceController {

    private final SkillResourceRepository resourceRepository;

    public SkillResourceController(SkillResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @GetMapping("/{skillId}/resources")
    public List<SkillResourceDTO> getResources(@PathVariable Long skillId) {

        return resourceRepository.findBySkillId(skillId).stream()
                .map(r -> new SkillResourceDTO(r.getType(), r.getUrl()))
                .toList();
    }
}
