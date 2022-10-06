package com.kpi.moviemanagementservice.models;

import lombok.Builder;
import lombok.Data;

import java.awt.image.BufferedImage;

@Data
@Builder
public class Movie {
    private Long id;
    private String name;
    private String description;
    private String imagePath;
    private BufferedImage image;
    private Long duration;
}
