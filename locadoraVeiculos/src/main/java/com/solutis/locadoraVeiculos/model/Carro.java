package com.solutis.locadoraVeiculos.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class Carro {
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorTotal;

}
