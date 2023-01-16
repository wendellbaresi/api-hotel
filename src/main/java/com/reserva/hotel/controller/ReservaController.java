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
    
    // Metodo de listar Reserva Unica pelo Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> UnicaReserva(@PathVariable(value = "id") Integer id){
        // Criando um optional para buscar pelo id que foi criado no Service
        Optional<Reserva> reservaOptional = reservaService.buscarPeloId(id);

        // If criado para caso esteja vazio a vaga, ele informar que não foi encontrado a reserva
        if (reservaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva não encontrada!");
        // e se for encontrado ele vai pegar(get) a reserva
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(reservaOptional.get());
        }
    }


    //Metodo de Deletar Reserva pelo Id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletarReserva(@PathVariable(value = "id") Integer id){
        Optional<Reserva> reservaOptional = reservaService.buscarPeloId(id);

        // If criado para caso esteja vazio a vaga, ele informar que não foi encontrado a reserva
        if (reservaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva não encontrada!");
            // e se for encontrado ele vai deletar pelo id, e informar ao usuario
        }else {
            reservaService.deletarPeloId(id);
            return ResponseEntity.status(HttpStatus.OK).body("Reserva Deletada do banco de dados.");
        }
    }


    // Metodo de Alterar a Reserva
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> alterarReserva(@PathVariable(value = "id") Integer id , @RequestBody @Valid ReservaDto reservaDto){
        Optional<Reserva> reservaOptional = reservaService.buscarPeloId(id);

        // If criado para caso esteja vazio a vaga, ele informar que não foi encontrado a reserva
        if (reservaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva não Encontrada!");
            // e se for encontrado ele vai fazer as alterações, pelos campos informados(entrada,saida,hospede,quarto)
        }else {
            var reserva = new Reserva();
            reserva.setEntrada(reserva.getEntrada());
            reserva.setSaida(reserva.getSaida());
            reserva.setHospede(reserva.getHospede());
            reserva.setQuarto(reserva.getQuarto());

            return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.salvar(reserva));
        }
    }
    
}
