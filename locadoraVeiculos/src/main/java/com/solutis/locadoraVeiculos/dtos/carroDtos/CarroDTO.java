package com.solutis.locadoraVeiculos.dtos.carroDtos;

import com.solutis.locadoraVeiculos.dtos.acessorioDto.AcessorioDTO;
import com.solutis.locadoraVeiculos.models.Categoria;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CarroDto {

    private String placa;

    private String chassi;

    private String cor;

    private BigDecimal valorDiaria;

    private List<Long> acessorios_id;

    private Long modeloCarro_id;
}

