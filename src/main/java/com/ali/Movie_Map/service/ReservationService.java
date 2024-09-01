package com.ali.Movie_Map.service;

import com.ali.Movie_Map.exception.UnavailableSeat;
import com.ali.Movie_Map.model.Reservation;
import com.ali.Movie_Map.model.Seat;
import com.ali.Movie_Map.repository.PaymentRepository;
import com.ali.Movie_Map.repository.ReservationRepository;
import com.ali.Movie_Map.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    public Reservation reserveSeat(Reservation reservation, List<Long> seatIds){
        List<Seat> seats = seatRepository.findAllById(seatIds);

        for(Seat seat:seats){
            if(!seat.isAvailable()){
                throw new UnavailableSeat("Seat" + seat.getSeatNumber() + "is not Available");
            }
        }

        for(Seat seat:seats){
            seat.setAvailable(false);
        }

        seatRepository.saveAll(seats);

        reservation.setSeatIds(String.join(",",seatIds.stream().map(String::valueOf).toArray(String[]::new)));
        reservation.setTotalAmount(seatIds.size()*300.0);
        return reservationRepository.save(reservation);
    }
}
