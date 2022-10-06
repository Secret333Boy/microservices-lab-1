package com.kpi.moviemanagementservice.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Place {
    private Long id;
    private Hall hall;
    private Long row;
    private Long placeNumber;
}
