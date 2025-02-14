package com.NammaMetro.UserService.controller;

import com.NammaMetro.UserService.entity.User;
import com.NammaMetro.UserService.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create or Update User
    @PostMapping
    public ResponseEntity<User> createOrUpdateUser(@RequestBody User user) {
        User saved = userService.saveUser(user);
        return ResponseEntity.ok(saved);
    }

    // Fetch User Profile (User Details + Travel History)
    // (We can rely on lazy loading or use a custom query/dto if needed)
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserProfile(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Delete a user
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.deleteUser(userId));
    }
}
