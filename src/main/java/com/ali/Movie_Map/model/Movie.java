package com.ali.Movie_Map.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String posterUrl;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<Showtime> showtimes;
}
