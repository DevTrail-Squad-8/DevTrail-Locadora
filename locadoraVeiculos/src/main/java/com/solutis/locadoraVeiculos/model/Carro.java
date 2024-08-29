package com.solutis.locadoraVeiculos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "Carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private String chassi;

    @Column(nullable = false)
    private String cor;

    @Column(nullable = false)
    private BigDecimal valorTotal;

<<<<<<< HEAD
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;
}
=======
    @ManyToMany
    private List<Acessorio> acessorios;

    @ManyToOne
    private ModeloCarro modeloCarro;

    @OneToMany(mappedBy = "carro")
    private List<Aluguel> alugueis;
    
}
>>>>>>> fe0ff53c2665c136fd272dd98bb3da990386cdbc
