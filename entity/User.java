package com.NammaMetro.UserService.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users") // Avoid using 'user' (reserved keyword in some DBs)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;

    // One user can have one MetroCard
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "user-metroCard")
    private MetroCard metroCard;

    // One user can have multiple travel history records
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TravelHistory> travelHistoryList;

    // One user can have multiple metro passes
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MetroPass> metroPassList;
}
