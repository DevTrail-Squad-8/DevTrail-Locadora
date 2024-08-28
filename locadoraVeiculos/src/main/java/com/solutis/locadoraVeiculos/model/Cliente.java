package com.solutis.locadoraVeiculos.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Cliente extends Pessoa {

    private String numeroCNH;
}
