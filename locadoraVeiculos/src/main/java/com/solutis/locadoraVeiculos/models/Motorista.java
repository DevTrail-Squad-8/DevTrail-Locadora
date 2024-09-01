package com.solutis.locadoraVeiculos.models;

import jakarta.persistence.*;
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
