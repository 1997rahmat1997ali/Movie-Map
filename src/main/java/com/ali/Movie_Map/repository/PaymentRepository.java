package com.ali.Movie_Map.repository;

import com.ali.Movie_Map.model.Payment;
import com.ali.Movie_Map.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
