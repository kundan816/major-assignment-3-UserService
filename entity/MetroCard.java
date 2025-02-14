package com.NammaMetro.UserService.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "metro_cards")
public class MetroCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;
    private Double balance;
    private Boolean isActive;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-metroCard")
    private User user;
}
