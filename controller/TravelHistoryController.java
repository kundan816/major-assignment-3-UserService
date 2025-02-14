package com.NammaMetro.UserService.controller;

import com.NammaMetro.UserService.entity.TravelHistory;
import com.NammaMetro.UserService.service.TravelHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/travel-history")
public class TravelHistoryController {

    private final TravelHistoryService travelHistoryService;

    public TravelHistoryController(TravelHistoryService travelHistoryService) {
        this.travelHistoryService = travelHistoryService;
    }

    // POST: Add a new travel history (journey) for a user
    @PostMapping("/{userId}")
    public ResponseEntity<TravelHistory> addTrip(@PathVariable Long userId,
                                                 @RequestBody TravelHistory travelHistory) {
        TravelHistory newTrip = travelHistoryService.addTrip(userId, travelHistory);
        return ResponseEntity.ok(newTrip);
    }

    // GET: Retrieve the last 10 trips for a user
    @GetMapping("/{userId}")
    public ResponseEntity<List<TravelHistory>> getLast10Trips(@PathVariable Long userId) {
        List<TravelHistory> trips = travelHistoryService.getLast10Trips(userId);
        return ResponseEntity.ok(trips);
    }
}
