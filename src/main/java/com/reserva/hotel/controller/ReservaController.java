package com.reserva.hotel.controller;

import com.reserva.hotel.dto.ReservaDto;
import com.reserva.hotel.model.Reserva;
import com.reserva.hotel.service.ReservaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;


@RestController
@RequestMapping(value = "/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> todasReservas(){
        return reservaService.reservas();
    }

    @PostMapping
    public ResponseEntity<Object> salvarReservas( @RequestBody @Valid ReservaDto reservaDto){
        if (reservaService.existsByQuarto(reservaDto.getQuarto())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Quarto reservado");
        }
        if (reservaService.existsByEntrada(reservaDto.getEntrada())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Está data o quarto já foi reservado");
        }


        var reserva = new Reserva();
        BeanUtils.copyProperties(reservaDto, reserva);
        // ENVIAR A DATA ATUAL DE ENTRADA DO HOSPEDE(Exemplo: Caso o hospede entre mais cedo ou mais tarde de sua resreva)
        reserva.setEntrada(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.salvar(reserva));
    }
}
