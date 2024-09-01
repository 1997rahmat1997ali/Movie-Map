package com.ali.Movie_Map.controller;

import com.ali.Movie_Map.model.Movie;
import com.ali.Movie_Map.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie){
        return movieRepository.save(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails){
        Movie movie = movieRepository.findById(id).orElseThrow();
        movie.setTitle(movieDetails.getTitle());
        movie.setDescription(movieDetails.getDescription());
        movie.setPosterUrl(movieDetails.getPosterUrl());
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id){
        movieRepository.deleteById(id);
    }

    @GetMapping()
    public List<Movie> getAllMovie(){
        return movieRepository.findAll();
    }
}
