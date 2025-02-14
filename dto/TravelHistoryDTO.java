package com.NammaMetro.UserService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelHistoryDTO {
    private Long id;
    private String sourceStation;
    private String destinationStation;
    private Double fare;
    private LocalDateTime travelDateTime;
}
