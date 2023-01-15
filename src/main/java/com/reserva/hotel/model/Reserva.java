package com.reserva.hotel.model;


import javax.persistence.*;
import java.time.LocalDateTime;

// Modelo de Reserva de Hotel

@Entity
@Table(name = "reserva")
public class Reserva {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false)
    private LocalDateTime entrada;

    @Column(nullable = false)
    private LocalDateTime saida;

    @OneToOne
    @JoinColumn(name = "hospede_id")
    private Hospede hospede;

    @OneToOne
    @JoinColumn(name = "quarto_id")
    private Quarto quarto;





    // Metodo Construtor vazio

    public Reserva(){

    }


    // Getter e Setter


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }


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


    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
}
