package com.ali.Movie_Map.controller;

import com.ali.Movie_Map.model.Reservation;
import com.ali.Movie_Map.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/reservation")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @PostMapping
    public Reservation reserveSeats(@RequestBody Reservation reservation){
        return reservationRepository.save(reservation);
    }

    @GetMapping
    public List<Reservation> getUserReservations(@PathVariable Long id){
        return reservationRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id){
        reservationRepository.deleteById(id);
    }
}
