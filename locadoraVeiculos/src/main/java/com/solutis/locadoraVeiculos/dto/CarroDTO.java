package com.solutis.locadoraVeiculos.dto;

import com.solutis.locadoraVeiculos.model.Categoria;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CarroDTO {
    private Long id;
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;
    private Categoria categoria;
    private List<AcessorioDTO> acessorios;
    private ModeloCarroDTO modeloCarro;
    private String imagem;
}
