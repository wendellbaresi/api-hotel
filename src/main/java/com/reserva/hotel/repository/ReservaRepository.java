package com.reserva.hotel.repository;

import com.reserva.hotel.model.Quarto;
import com.reserva.hotel.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query(value = "select c from Reserva c where (:quarto_id is null or c.quarto = :quarto_id) and (:entrada is null or c.entrada = :entrada)")
    public List<Reserva> existsByQuartoIdAndEntrada(Quarto quarto_id, LocalDateTime entrada);
    public boolean existsByEntrada(LocalDateTime entrada);
}
