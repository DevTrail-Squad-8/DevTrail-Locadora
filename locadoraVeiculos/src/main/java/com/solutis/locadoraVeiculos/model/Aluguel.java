package com.solutis.locadoraVeiculos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataPedido;

    private LocalDateTime dataEntrega;

    private LocalDateTime dataDevolucao;

    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;

    @OneToOne
    private ApoliceSeguro apoliceSeguro;

    @ManyToOne
    private Cliente cliente;
}