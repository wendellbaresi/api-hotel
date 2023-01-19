package com.reserva.hotel.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "quarto")
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("n_quarto")
    private String nQuarto;


    // Metodo Construtor
    public Quarto(){

    }

    // Getter e Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getN_quarto() {
        return nQuarto;
    }

    public void setN_quarto(String n_quarto) {
        this.nQuarto = n_quarto;
    }
}
