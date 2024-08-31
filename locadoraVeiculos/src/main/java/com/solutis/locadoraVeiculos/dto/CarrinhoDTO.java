package com.solutis.locadoraVeiculos.dto;

import java.math.BigDecimal;
import java.util.List;

public class CarrinhoDTO {
    private Long id;
    private Long clienteId;
    private List<AluguelDTO> alugueis;
    private BigDecimal valorTotal;
    

}
