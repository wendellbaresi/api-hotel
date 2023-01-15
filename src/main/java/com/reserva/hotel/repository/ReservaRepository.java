package com.reserva.hotel.repository;

import com.reserva.hotel.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    public boolean existsByQuarto(String quarto);
    public boolean existsByEntrada(LocalDateTime entrada);
}
