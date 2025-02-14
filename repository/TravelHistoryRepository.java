package com.NammaMetro.UserService.repository;

import com.NammaMetro.UserService.entity.TravelHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TravelHistoryRepository extends JpaRepository<TravelHistory, Long> {
    List<TravelHistory> findTop10ByUserIdOrderByTravelDateTimeDesc(Long userId);
}
