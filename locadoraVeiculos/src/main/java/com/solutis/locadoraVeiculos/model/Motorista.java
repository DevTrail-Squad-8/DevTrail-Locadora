package com.solutis.locadoraVeiculos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Motorista extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String numeroCNH;

    @OneToMany(mappedBy = "motorista")
    @JsonIgnoreProperties("motorista")
    private List<Aluguel> alugueis;
}
