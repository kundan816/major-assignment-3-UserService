package com.NammaMetro.UserService.controller;

import com.NammaMetro.UserService.entity.MetroCard;
import com.NammaMetro.UserService.service.MetroCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/metro-card")
public class MetroCardController {

    private final MetroCardService metroCardService;

    public MetroCardController(MetroCardService metroCardService) {
        this.metroCardService = metroCardService;
    }

    // Buy Metro Card
    @PostMapping("/buy/{userId}")
    public ResponseEntity<MetroCard> buyMetroCard(@PathVariable Long userId) {
        MetroCard card = metroCardService.buyMetroCard(userId);
        return ResponseEntity.ok(card);
    }
}
