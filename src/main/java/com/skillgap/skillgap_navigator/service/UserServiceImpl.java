package com.skillgap.skillgap_navigator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillgap.skillgap_navigator.dto.UserDTO;
import com.skillgap.skillgap_navigator.entity.Skill;
import com.skillgap.skillgap_navigator.entity.User;
import com.skillgap.skillgap_navigator.repository.SkillRepository;
import com.skillgap.skillgap_navigator.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SkillRepository skillRepository;

    public UserServiceImpl(UserRepository userRepository,
                           SkillRepository skillRepository) {
        this.userRepository = userRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user = new User();
        user.setName(userDTO.getName());

        User saved = userRepository.save(user);

        return new UserDTO(saved.getId(), saved.getName(), List.of());
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDTO(
                        user.getId(),
                        user.getName(),
                        user.getSkills() == null
                                ? List.of()
                                : user.getSkills()
                                      .stream()
                                      .map(Skill::getId)
                                      .toList()
                ))
                .toList();
    }

    @Override
    public UserDTO assignSkills(Long userId, List<Long> skillIds) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Skill> skills = skillRepository.findAllById(skillIds);
        user.setSkills(skills);

        User saved = userRepository.save(user);

        return new UserDTO(
                saved.getId(),
                saved.getName(),
                skills.stream().map(Skill::getId).toList()
        );
    }
}
