package com.NammaMetro.UserService.controller;

import com.NammaMetro.UserService.entity.MetroPass;
import com.NammaMetro.UserService.service.MetroPassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/metro-pass")
public class MetroPassController {

    private final MetroPassService metroPassService;

    public MetroPassController(MetroPassService metroPassService) {
        this.metroPassService = metroPassService;
    }

    // Endpoint to create a metro pass (for testing)
    @PostMapping("/create/{userId}")
    public ResponseEntity<MetroPass> createMetroPass(@PathVariable Long userId,
                                                     @RequestBody MetroPass metroPass) {
        MetroPass newPass = metroPassService.createMetroPass(userId, metroPass);
        return ResponseEntity.ok(newPass);
    }

    // Cancel an active metro pass
    @PostMapping("/cancel/{userId}")
    public ResponseEntity<String> cancelPass(@PathVariable Long userId) {
        String response = metroPassService.cancelPass(userId);
        return ResponseEntity.ok(response);
    }
}
