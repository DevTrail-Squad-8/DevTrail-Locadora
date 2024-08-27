package com.solutis.locadoraVeiculos.model;

import jakarta.persistence.Entity;

@Entity
public class Cliente extends Pessoa {
    private String numeroCNH;

}
