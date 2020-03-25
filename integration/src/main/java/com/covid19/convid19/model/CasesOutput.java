package com.covid19.convid19.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CasesOutput {
    private String id;
    private String displayName;
    private Integer totalConfirmed;
    private Integer totalDeaths;
    private Integer totalRecovered;
    private LocalDateTime lastUpdated;
    private List<CasesOutput> areas;
}
