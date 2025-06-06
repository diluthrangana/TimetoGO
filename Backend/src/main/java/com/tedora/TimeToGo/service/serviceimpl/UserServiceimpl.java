package com.tedora.TimeToGo.service.serviceimpl;

import com.tedora.TimeToGo.dto.UsersDTO;
import com.tedora.TimeToGo.entity.Users;
import com.tedora.TimeToGo.repository.UsersRepository;
import com.tedora.TimeToGo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    private UsersDTO mapToDTO(Users user) {
        return new UsersDTO(user.getUserId(), user.getUsername(), user.getEmail(), user.getPassword());
    }

    private Users mapToEntity(UsersDTO dto) {
        return new Users(dto.getUsername(), dto.getEmail(), dto.getPassword());
    }

    @Override
    public UsersDTO createUser(UsersDTO userDTO) {
        Users user = mapToEntity(userDTO);
        Users savedUser = usersRepository.save(user);
        return mapToDTO(savedUser);
    }

    @Override
    public UsersDTO getUserById(Long userId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToDTO(user);
    }

    @Override
    public List<UsersDTO> getAllUsers() {
        return usersRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsersDTO updateUser(Long userId, UsersDTO userDTO) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return mapToDTO(usersRepository.save(user));
    }

    @Override
    public void deleteUser(Long userId) {
        usersRepository.deleteById(userId);
    }
}
