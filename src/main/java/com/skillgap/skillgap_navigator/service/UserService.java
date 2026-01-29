package com.skillgap.skillgap_navigator.service;

import java.util.List;
import com.skillgap.skillgap_navigator.dto.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    UserDTO assignSkills(Long userId, List<Long> skillIds);
}
