package com.solutis.locadoraVeiculos.dto;

import java.time.LocalDate;

import com.solutis.locadoraVeiculos.model.Sexo;
import lombok.Data;

@Data
public class ClienteDTO {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String email;
    private Sexo sexo;
    private String numeroCNH;
}
