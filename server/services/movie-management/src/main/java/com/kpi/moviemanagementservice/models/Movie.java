package com.kpi.moviemanagementservice.models;

import lombok.*;

import javax.persistence.*;
import java.awt.image.BufferedImage;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String imagePath;
    @Transient
    private BufferedImage image;
    private Long duration;
}
