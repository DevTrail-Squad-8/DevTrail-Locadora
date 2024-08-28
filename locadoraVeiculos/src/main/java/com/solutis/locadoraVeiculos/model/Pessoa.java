package com.solutis.locadoraVeiculos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private String cpf;
    private String email;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;
}