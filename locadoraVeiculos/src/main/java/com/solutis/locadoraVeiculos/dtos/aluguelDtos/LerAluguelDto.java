package com.solutis.locadoraVeiculos.dtos.aluguelDtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.solutis.locadoraVeiculos.model.ApoliceSeguro;
import com.solutis.locadoraVeiculos.model.Carro;
import com.solutis.locadoraVeiculos.model.Motorista;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class LerAluguelDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate dataPedido;

    private Date dataEntrega;

    private Date dataDevolucao;

    private BigDecimal valorTotal;

    private Motorista motorista;

    @JsonIgnoreProperties("aluguel")
    private ApoliceSeguro apoliceSeguro;

    private List<Carro> carros;
}
