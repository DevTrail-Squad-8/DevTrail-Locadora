package com.solutis.locadoraVeiculos.dtos.modelosCarroDto;

import java.util.List;

@Data
public class LerModeloCarroDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @JsonIgnoreProperties("modelos")
    private Fabricante fabricante;


    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonIgnoreProperties({"modeloCarro", "acessorios"})
    private List<Carro> carros;

}
