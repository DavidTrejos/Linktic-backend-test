package com.test.reservation_system_backend.controller;

import com.test.reservation_system_backend.entity.Reservation;
import com.test.reservation_system_backend.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) throws BadRequestException {
        if (reservation.getUser() == null || reservation.getUser().getId() == null) {
            throw new BadRequestException("User ID is missing");
        }

        return ResponseEntity.ok(reservationService.save(reservation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.update(id, reservation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Reservation>> getAllReservationsByUserId(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.findAllByUserId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Reservation>> getReservationById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.findAllById(id));
    }
}
