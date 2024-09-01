package com.solutis.locadoraVeiculos.dtos.carroDtos;

import java.math.BigDecimal;
import java.util.List;

import com.solutis.locadoraVeiculos.dtos.aluguelDtos.AluguelDTO;

@Data
public class LerCarroDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String placa;

    private String chassi;

    private String cor;

    private BigDecimal valorDiaria;

    @JsonIgnoreProperties({"carros"})
    private List<Acessorio> acessorios;

    @JsonIgnoreProperties({"carros"})
    private ModeloCarro modeloCarro;
}
