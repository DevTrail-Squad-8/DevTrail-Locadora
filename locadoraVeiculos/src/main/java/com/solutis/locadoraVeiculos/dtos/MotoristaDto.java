package com.solutis.locadoraVeiculos.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.solutis.locadoraVeiculos.model.Sexo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MotoristaDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String nome;

    @Schema(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;
    private String cpf;
    private String email;
    private Sexo sexo;
    private String numeroCNH;
}
