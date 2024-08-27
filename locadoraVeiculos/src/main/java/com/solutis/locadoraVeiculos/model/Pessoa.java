package com.solutis.locadoraVeiculos.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
public abstract class Pessoa {
    private Long id;

    private String nome;

    @Temporal(TemporalType.DATE)
    private Data dataNascimento;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;


}
