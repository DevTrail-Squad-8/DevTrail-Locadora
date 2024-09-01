package com.solutis.locadoraVeiculos.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Data
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String descricao;

    @ManyToMany(mappedBy = "acessorios")
    @JsonIgnoreProperties("acessorios")
    private List<Carro> carros;

}
