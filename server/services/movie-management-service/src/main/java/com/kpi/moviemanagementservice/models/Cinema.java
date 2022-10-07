package com.kpi.moviemanagementservice.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cinema {
    private Long id;
    private String name;
    private String location;
}
