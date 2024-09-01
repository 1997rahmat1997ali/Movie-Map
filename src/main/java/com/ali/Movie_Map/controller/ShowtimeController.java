package com.ali.Movie_Map.controller;

import com.ali.Movie_Map.model.Showtime;
import com.ali.Movie_Map.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/showtimes")
public class ShowtimeController {
    @Autowired
    private ShowtimeRepository showtimeRepository;

    @PostMapping
    public Showtime addShowtime(@RequestBody Showtime showtime){
        return showtimeRepository.save(showtime);
    }

    @GetMapping
    public List<Showtime> getAllShowtime(){
        return showtimeRepository.findAll();
    }
}
