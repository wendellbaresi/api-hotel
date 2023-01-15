package com.reserva.hotel.model;


import javax.persistence.*;

@Entity
@Table(name = "quarto")
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String n_quarto;


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
        return n_quarto;
    }

    public void setN_quarto(String n_quarto) {
        this.n_quarto = n_quarto;
    }
}
