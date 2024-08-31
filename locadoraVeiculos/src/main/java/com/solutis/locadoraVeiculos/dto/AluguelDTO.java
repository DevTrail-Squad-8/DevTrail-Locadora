package com.solutis.locadoraVeiculos.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;




public class AluguelDTO {
    private Long id;
    private Long carroId;
    private Long clienteId;
    private LocalDateTime dataPedido;
    private LocalDateTime dataEntrega;
    private LocalDateTime dataDevolucao;
    private BigDecimal valorTotal;

}
