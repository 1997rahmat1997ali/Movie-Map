package com.ali.Movie_Map.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Reservation reservation;
    private double amount;
    private String paymentStatus;
}
