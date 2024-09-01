package com.solutis.locadoraVeiculos.dtos.acessorioDto;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

import lombok.Data;


@Data
public class AcessorioDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String descricao;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonIgnoreProperties("acessorios")
    private List<Long> carros;

}
