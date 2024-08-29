package com.solutis.locadoraVeiculos.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
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