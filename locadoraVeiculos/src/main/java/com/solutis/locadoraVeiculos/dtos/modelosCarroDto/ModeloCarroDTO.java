package com.solutis.locadoraVeiculos.dtos.modelosCarroDto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.solutis.locadoraVeiculos.model.Categoria;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class ModeloCarroDto {

    @Column
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @JsonIgnoreProperties("modelos")
    private Long fabricante_id;

}

