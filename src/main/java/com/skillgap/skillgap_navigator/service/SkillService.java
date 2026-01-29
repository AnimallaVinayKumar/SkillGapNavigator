package com.skillgap.skillgap_navigator.service;

import java.util.List;
import com.skillgap.skillgap_navigator.dto.SkillDTO;

public interface SkillService {
    List<SkillDTO> getAllSkills();
    SkillDTO createSkill(SkillDTO skillDTO); // move inside interface
}
