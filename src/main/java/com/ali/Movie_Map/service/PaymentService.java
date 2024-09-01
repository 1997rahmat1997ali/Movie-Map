package com.ali.Movie_Map.service;

import com.ali.Movie_Map.model.Payment;
import com.ali.Movie_Map.model.Reservation;
import com.ali.Movie_Map.repository.PaymentRepository;
import com.ali.Movie_Map.repository.ReservationRepository;
import com.ali.Movie_Map.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    public Payment paymentProcess(Reservation reservation, double amount){
        Payment payment = new Payment();
        payment.setReservation(reservation);
        payment.setAmount(amount);
        payment.setPaymentStatus("SUCCESS");
        return paymentRepository.save(payment);
    }

}
