package com.NammaMetro.UserService.service;

import com.NammaMetro.UserService.entity.MetroCard;
import com.NammaMetro.UserService.entity.User;
import com.NammaMetro.UserService.repository.MetroCardRepository;
import com.NammaMetro.UserService.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MetroCardService {

    private final MetroCardRepository metroCardRepository;
    private final UserRepository userRepository;

    public MetroCardService(MetroCardRepository metroCardRepository,
                            UserRepository userRepository) {
        this.metroCardRepository = metroCardRepository;
        this.userRepository = userRepository;
    }

    public MetroCard buyMetroCard(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        // Check if user already has a card
        if (user.getMetroCard() != null && Boolean.TRUE.equals(user.getMetroCard().getIsActive())) {
            throw new RuntimeException("User already has an active Metro Card!");
        }

        MetroCard card = new MetroCard();
        card.setUser(user);
        card.setCardNumber(UUID.randomUUID().toString());
        card.setBalance(0.0);
        card.setIsActive(true);

        return metroCardRepository.save(card);
    }
}
