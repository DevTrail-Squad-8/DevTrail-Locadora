package com.solutis.locadoraVeiculos.dtos.fabricantesDto;

import java.util.List;

@Data
public class LerFabricanteDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String nome;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonIgnoreProperties("fabricante")
    private List<ModeloCarro> modelos;
}
