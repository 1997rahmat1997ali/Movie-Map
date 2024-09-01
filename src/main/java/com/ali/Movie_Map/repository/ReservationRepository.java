package com.ali.Movie_Map.repository;

import com.ali.Movie_Map.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
