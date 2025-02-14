package com.NammaMetro.UserService.service;

import com.NammaMetro.UserService.entity.MetroPass;
import com.NammaMetro.UserService.entity.User;
import com.NammaMetro.UserService.repository.MetroPassRepository;
import com.NammaMetro.UserService.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class MetroPassService {

    private final MetroPassRepository metroPassRepository;
    private final UserRepository userRepository;

    public MetroPassService(MetroPassRepository metroPassRepository, UserRepository userRepository) {
        this.metroPassRepository = metroPassRepository;
        this.userRepository = userRepository;
    }

    // Create an active metro pass for a given user (for testing purposes)
    public MetroPass createMetroPass(Long userId, MetroPass metroPass) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        metroPass.setUser(user);
        metroPass.setIsActive(true);
        return metroPassRepository.save(metroPass);
    }

    // Existing cancel pass method
    public String cancelPass(Long userId) {
        MetroPass pass = metroPassRepository.findByUserIdAndIsActiveTrue(userId)
                .orElseThrow(() -> new RuntimeException("No active pass found for user ID: " + userId));
        pass.setIsActive(false);
        metroPassRepository.save(pass);
        return "Metro pass canceled successfully!";
    }
}
