package com.ali.Movie_Map.repository;

import com.ali.Movie_Map.model.Showtime;
import com.ali.Movie_Map.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeRepository extends JpaRepository<Showtime,Long> {

}
