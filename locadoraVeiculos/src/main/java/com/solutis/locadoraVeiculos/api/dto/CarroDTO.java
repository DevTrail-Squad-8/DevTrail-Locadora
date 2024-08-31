package com.solutis.locadoraVeiculos.api.dto;

import com.solutis.locadoraVeiculos.infra.entity.Categoria;

import java.math.BigDecimal;
import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<AcessorioDTO> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<AcessorioDTO> acessorios) {
        this.acessorios = acessorios;
    }

    public ModeloCarroDTO getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(ModeloCarroDTO modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
