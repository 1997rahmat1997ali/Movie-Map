package com.ali.Movie_Map.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
    private LocalDateTime time;
    @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL)
    private Set<Seat> seats;
}
