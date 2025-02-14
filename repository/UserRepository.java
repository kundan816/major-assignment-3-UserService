package com.NammaMetro.UserService.repository;

import com.NammaMetro.UserService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Fetch a user along with its associated metro card, travel history, and metro passes.
     * This query uses LEFT JOIN FETCH to eagerly load related collections and associations.
     *
     * @param userId the ID of the user to retrieve
     * @return the User entity with all associated details, or null if not found
     */
    @Query("SELECT u FROM User u " +
            "LEFT JOIN FETCH u.metroCard " +
            "LEFT JOIN FETCH u.travelHistoryList " +
            "LEFT JOIN FETCH u.metroPassList " +
            "WHERE u.id = :userId")
    User findUserWithAllDetailsById(@Param("userId") Long userId);
}
