package com.NammaMetro.UserService.service;

import com.NammaMetro.UserService.entity.TravelHistory;
import com.NammaMetro.UserService.entity.User;
import com.NammaMetro.UserService.repository.TravelHistoryRepository;
import com.NammaMetro.UserService.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelHistoryService {

    private final TravelHistoryRepository travelHistoryRepository;
    private final UserRepository userRepository; // To lookup the user

    public TravelHistoryService(TravelHistoryRepository travelHistoryRepository, UserRepository userRepository) {
        this.travelHistoryRepository = travelHistoryRepository;
        this.userRepository = userRepository;
    }

    // Add a new trip (journey) for a given user
    public TravelHistory addTrip(Long userId, TravelHistory travelHistory) {
        // Find the user; throw an exception if not found.
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        travelHistory.setUser(user);
        // Optionally, if travelDateTime is not provided in the request, set it here:
        // travelHistory.setTravelDateTime(LocalDateTime.now());
        return travelHistoryRepository.save(travelHistory);
    }

    // Retrieve last 10 trips for a user
    public List<TravelHistory> getLast10Trips(Long userId) {
        return travelHistoryRepository.findTop10ByUserIdOrderByTravelDateTimeDesc(userId);
    }
}
