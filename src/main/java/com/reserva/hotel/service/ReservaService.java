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
    public boolean existsByQuarto(String n_quarto){
        return reservaRepository.existsByQuarto(n_quarto);
    }

    public boolean existsByEntrada(LocalDateTime entrada){
        return reservaRepository.existsByEntrada(entrada);
    }

    //Listar pelo Id
    public Optional<Reserva> buscarPeloId(Integer id){
        return reservaRepository.findById(id);
    }

    // Criando serviço de Deletar
    public void deletarPeloId(Integer id){
         reservaRepository.deleteById(id);
    }
}
