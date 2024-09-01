package com.solutis.locadoraVeiculos.dtos;

@Data
public class ApoliceDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private BigDecimal valorFranquia;

    private boolean protecaoTerceiro;

    private boolean protecaoCausasNaturais;

    private boolean protecaoRoubo;

}
