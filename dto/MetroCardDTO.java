package com.NammaMetro.UserService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for MetroCard details.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetroCardDTO {
    private Long id;
    private String cardNumber;
    private Double balance;
    private Boolean isActive;
}
