package com.NammaMetro.UserService.service;

import com.NammaMetro.UserService.entity.User;
import com.NammaMetro.UserService.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create or update a user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get user by ID
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Delete user
    public String deleteUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return "User deleted successfully!";
        }
        return "User not found!";
    }
}
