package com.solutis.locadoraVeiculos.dtos.acessorioDto;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.solutis.locadoraVeiculos.model.Carro;

import lombok.Data;

import java.util.List;

@Data
public class LerAcessorioDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String descricao;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonIgnoreProperties("acessorios")
    private List<Carro> carros;

}
