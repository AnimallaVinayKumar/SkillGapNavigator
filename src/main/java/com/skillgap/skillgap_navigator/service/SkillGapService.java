package com.skillgap.skillgap_navigator.service;

import com.skillgap.skillgap_navigator.dto.SkillGapResponseDTO;

public interface SkillGapService {

    SkillGapResponseDTO calculateSkillGap(Long userId, Long pathId);
}
