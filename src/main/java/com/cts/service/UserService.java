package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.dtos.UserRequestDTO;
import com.cts.entity.User;
import com.cts.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No user by ID: " + id));
    }

    public User saveUser(UserRequestDTO userRequest) {
        User user = User.builder()
            .name(userRequest.getName())
            .email(userRequest.getEmail())
            .mobile(userRequest.getMobile())
            .age(userRequest.getAge())
        .build();
        return userRepository.save(user);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public void saveAllUsers(List<User> users) {
        userRepository.saveAll(users);
    }

}