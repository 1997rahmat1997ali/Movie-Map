package com.ali.Movie_Map.repository;

import com.ali.Movie_Map.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
