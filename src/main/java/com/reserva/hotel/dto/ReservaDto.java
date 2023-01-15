package com.reserva.hotel.dto;

import com.reserva.hotel.model.Hospede;
import com.reserva.hotel.model.Quarto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class ReservaDto {

    @NotBlank
    private LocalDateTime entrada;


    @NotBlank
    private LocalDateTime saida;


    @NotBlank
    private Hospede hospede;

    @NotBlank
    private Quarto quarto;



    // Metodos Getter e Setter


    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
}
