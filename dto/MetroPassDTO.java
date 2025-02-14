package com.NammaMetro.UserService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * DTO for MetroPass details.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetroPassDTO {
    private Long id;
    private String passType;
    private LocalDateTime startDate;
    private LocalDateTime expiryDate;
    private Boolean isActive;
}
