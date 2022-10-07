package com.kpi.moviemanagementservice.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hall {
    private Long id;
    private String name;
    private Cinema cinema;
}
