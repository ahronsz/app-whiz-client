package com.whiz.service.expose.dto.reponse;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class KpiClientResponseDto {
    private Double averageAge;
    private Double standardDeviation;
}
