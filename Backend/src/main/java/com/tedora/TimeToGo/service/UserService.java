package com.tedora.TimeToGo.service;

import com.tedora.TimeToGo.dto.UsersDTO;
import java.util.List;

public interface UserService {
    UsersDTO createUser(UsersDTO userDTO);
    UsersDTO getUserById(Long userId);
    List<UsersDTO> getAllUsers();
    UsersDTO updateUser(Long userId, UsersDTO userDTO);
    void deleteUser(Long userId);
}
