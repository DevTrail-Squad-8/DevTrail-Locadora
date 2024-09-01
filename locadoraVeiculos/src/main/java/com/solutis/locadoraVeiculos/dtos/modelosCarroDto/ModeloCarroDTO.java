package com.solutis.locadoraVeiculos.dtos.modelosCarroDto;

import java.util.List;

@Data
public class ModeloCarroDto {

    @Column
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @JsonIgnoreProperties("modelos")
    private Long fabricante_id;

}

