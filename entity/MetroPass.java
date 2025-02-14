package com.NammaMetro.UserService.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "metro_passes")
public class MetroPass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passType;      // e.g., "Daily", "Monthly", "Yearly"
    private LocalDateTime startDate;
    private LocalDateTime expiryDate;
    private Boolean isActive;     // true if pass is valid, false if canceled

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-metroPass")
    private User user;
}
