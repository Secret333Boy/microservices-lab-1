package com.kpi.moviemanagementservice.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CinemaFeedback {
    private Long id;
    private Long userId;
    private Cinema cinema;
    private Integer score;
    private String comment;
}
