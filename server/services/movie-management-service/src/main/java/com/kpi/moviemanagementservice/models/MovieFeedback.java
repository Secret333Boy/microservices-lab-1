package com.kpi.moviemanagementservice.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieFeedback {
    private Long id;
    private Long userId;
    private Movie movie;
    private Integer score;
    private String comment;
}
