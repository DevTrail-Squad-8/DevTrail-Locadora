package com.solutis.locadoraVeiculos.dtos.carroDtos;

import com.solutis.locadoraVeiculos.model.Carro;
import java.math.BigDecimal;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.solutis.locadoraVeiculos.model.Acessorio;
import com.solutis.locadoraVeiculos.model.ModeloCarro;

import lombok.Data;


@Data
public class LerCarroDto {

    public LerCarroDto() {
    }

    public LerCarroDto(Carro carro) {
        this.id = carro.getId();
        this.placa = carro.getPlaca();
        this.chassi = carro.getChassi();
        this.cor = carro.getCor();
        this.valorDiaria = carro.getValorDiaria();
        this.acessorios = carro.getAcessorios();
        this.modeloCarro = carro.getModeloCarro();
    }

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
