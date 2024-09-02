package com.test.reservation_system_backend.service;

import com.test.reservation_system_backend.entity.Reservation;
import com.test.reservation_system_backend.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public void delete(Long id) {
        try{
            System.out.println("Entro"+id);
            reservationRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public List<Reservation> findAllByUserId(Long id) {
        return reservationRepository.findAllByUserId(id);
    }

    public List<Reservation> findAllById(Long id) {
        List<Long> ids = new ArrayList<>();
        ids.add(id);
        return reservationRepository.findAllById(ids);
    }

    public Reservation update(Long id, Reservation reservation) {
        Reservation existingReservation = reservationRepository.findById(id).orElseThrow();
        existingReservation.setServiceType(reservation.getServiceType());
        existingReservation.setReservationDate(reservation.getReservationDate());
        return reservationRepository.save(existingReservation);
    }
}
