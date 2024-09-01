package com.solutis.locadoraVeiculos.dtos.fabricantesDto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class FabricanteDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String nome;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonIgnoreProperties("fabricante")
    private List<Long> modelos;
}
