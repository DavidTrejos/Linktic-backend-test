package com.test.reservation_system_backend.repository;
import com.test.reservation_system_backend.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

    List<Reservation> findAllByUserId(Long id);



}
