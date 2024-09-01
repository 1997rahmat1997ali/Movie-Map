package com.ali.Movie_Map.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Showtime showtime;
    private String seatIds;
    private LocalDateTime reservationTime;
    private double totalAmount;
}

