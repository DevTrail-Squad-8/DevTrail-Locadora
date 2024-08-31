package com.solutis.locadoraVeiculos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ModeloCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @ManyToOne
    private Fabricante fabricante;

    @OneToMany(mappedBy = "modeloCarro")
    private List<Carro> carros;
}
