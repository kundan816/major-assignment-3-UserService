package com.NammaMetro.UserService.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "travel_history")
public class TravelHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceStation;
    private String destinationStation;
    private Double fare;
    private LocalDateTime travelDateTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-travelHistory")
    private User user;
}
