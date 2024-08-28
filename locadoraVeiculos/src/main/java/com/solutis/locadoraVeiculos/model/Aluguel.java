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

    @Temporal(TemporalType.DATE)
    private LocalDateTime dataEntrega;

    @Temporal(TemporalType.DATE)
    private LocalDateTime dataDevolucao;

    private BigDecimal valorTotal;
}
