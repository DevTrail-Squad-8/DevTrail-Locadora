package com.solutis.locadoraVeiculos.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ApoliceDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private BigDecimal valorFranquia;

    private boolean protecaoTerceiro;

    private boolean protecaoCausasNaturais;

    private boolean protecaoRoubo;

}
