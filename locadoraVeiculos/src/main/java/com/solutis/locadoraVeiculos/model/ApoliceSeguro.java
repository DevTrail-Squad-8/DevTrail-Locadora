package com.solutis.locadoraVeiculos.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class ApoliceSeguro {
    private BigDecimal valorFranquia;
   private boolean protecaoTerceiro;
   private boolean protecaoCausasNaturais;
   private boolean protecaoRoubo;

}
