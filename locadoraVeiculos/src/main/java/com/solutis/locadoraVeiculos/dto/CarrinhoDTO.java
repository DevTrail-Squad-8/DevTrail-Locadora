package com.solutis.locadoraVeiculos.dto;

import java.math.BigDecimal;
import java.util.List;

public class CarrinhoDTO {
    private Long id;
    private Long clienteId;
    private List<AluguelDTO> alugueis;
    private BigDecimal valorTotal;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getClienteId() {
        return clienteId;
    }
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
    public List<AluguelDTO> getAlugueis() {
        return alugueis;
    }
    public void setAlugueis(List<AluguelDTO> alugueis) {
        this.alugueis = alugueis;
    }
    public BigDecimal getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    

}
