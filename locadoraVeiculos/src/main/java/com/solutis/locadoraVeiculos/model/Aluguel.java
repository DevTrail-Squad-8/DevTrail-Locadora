package com.solutis.locadoraVeiculos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
}
