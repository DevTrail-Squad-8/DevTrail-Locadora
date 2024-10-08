package com.solutis.locadoraVeiculos.dtos.modelosCarroDto;

import com.solutis.locadoraVeiculos.model.ModeloCarro;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.solutis.locadoraVeiculos.model.Carro;
import com.solutis.locadoraVeiculos.model.Categoria;
import com.solutis.locadoraVeiculos.model.Fabricante;


import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class LerModeloCarroDto {

    public LerModeloCarroDto() {
    }

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

    public LerModeloCarroDto(ModeloCarro entity) {
        this.id = entity.getId();
        this.descricao = entity.getDescricao();
        this.categoria = entity.getCategoria();
        this.fabricante = entity.getFabricante();
        this.carros = entity.getCarros();
    }
}
