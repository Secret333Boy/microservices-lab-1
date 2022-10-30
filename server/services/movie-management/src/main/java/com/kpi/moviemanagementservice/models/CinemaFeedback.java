package com.kpi.moviemanagementservice.models;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "cinema_feedback")
public class CinemaFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;
    private Integer score;
    private String comment;
}
