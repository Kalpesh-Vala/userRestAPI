package com.kpvala.userrestapi.service.impl;

import com.kpvala.userrestapi.dto.UserDto;
import com.kpvala.userrestapi.entity.User;
import com.kpvala.userrestapi.exception.ResourceNotFoundException;
import com.kpvala.userrestapi.mapper.UserMapper;
import com.kpvala.userrestapi.repository.UserRepository;
import com.kpvala.userrestapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);

        return UserMapper.mapTOUserDto(savedUser);
    }

    @Override
    public UserDto getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id " + userId));

        return UserMapper.mapTOUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapTOUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {

        User user = userRepository.findById(userId).
                orElseThrow(() -> new ResourceNotFoundException("User does not exist with id " + userId));

        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());

        User updatedUserObj = userRepository.save(user);

        return UserMapper.mapTOUserDto(updatedUserObj);
    }

    @Override
    public void deleteUser(Long userId) {

        User user = userRepository.findById(userId).
                orElseThrow(() -> new ResourceNotFoundException("User does not exist with id " + userId));

        userRepository.deleteById(userId);
    }
}
