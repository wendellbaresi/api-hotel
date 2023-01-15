package com.reserva.hotel.service;

import com.reserva.hotel.model.Reserva;
import com.reserva.hotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;


    // Listar tudo
    public List<Reserva> reservas(){
        return reservaRepository.findAll();
    }


    public Reserva salvar(Reserva reserva){
        return reservaRepository.save(reserva);
    }



    // Criacao do Serviço para informar se existe ou nao naquele dia o quarto esta livre
    public boolean existsByQuarto(String quarto){
        return reservaRepository.existsByQuarto(quarto);
    }

    public boolean existsByEntrada(LocalDateTime entrada){
        return reservaRepository.existsByEntrada(entrada);
    }




}
