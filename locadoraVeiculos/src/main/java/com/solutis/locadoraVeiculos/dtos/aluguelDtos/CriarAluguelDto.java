package com.solutis.locadoraVeiculos.dtos.aluguelDtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CriarAluguelDto {


    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate dataPedido;

    private Date dataEntrega;

    private Date dataDevolucao;

    private BigDecimal valorTotal;

    private Long motorista_id;

    private Long apolicesSeguro_id;

    private List<Long> carros_id;
}

