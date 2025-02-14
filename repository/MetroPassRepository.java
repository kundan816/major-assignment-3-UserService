package com.NammaMetro.UserService.repository;

import com.NammaMetro.UserService.entity.MetroPass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MetroPassRepository extends JpaRepository<MetroPass, Long> {
    Optional<MetroPass> findByUserIdAndIsActiveTrue(Long userId);
}
