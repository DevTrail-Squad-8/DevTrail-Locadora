package com.solutis.locadoraVeiculos.dtos.carroDtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.solutis.locadoraVeiculos.model.Acessorio;
import com.solutis.locadoraVeiculos.model.Carro;
import com.solutis.locadoraVeiculos.model.ModeloCarro;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;


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

    private Double valorDiaria;

    @JsonIgnoreProperties({"carros"})
    private List<Acessorio> acessorios;

    @JsonIgnoreProperties({"carros"})
    private ModeloCarro modeloCarro;
}
