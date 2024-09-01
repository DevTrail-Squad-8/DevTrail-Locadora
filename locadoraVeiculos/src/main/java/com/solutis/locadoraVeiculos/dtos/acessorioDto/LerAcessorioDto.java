package com.solutis.locadoraVeiculos.dtos.acessorioDto;

@Data
public class LerAcessorioDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String descricao;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonIgnoreProperties("acessorios")
    private List<Carro> carros;

}
