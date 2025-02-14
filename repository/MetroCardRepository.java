package com.NammaMetro.UserService.repository;

import com.NammaMetro.UserService.entity.MetroCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MetroCardRepository extends JpaRepository<MetroCard, Long> {
    Optional<MetroCard> findByUserId(Long userId);
}
