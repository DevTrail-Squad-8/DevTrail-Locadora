package com.solutis.locadoraVeiculos.dtos;

import java.time.LocalDate;

@Data
public class FuncionarioDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String nome;

    @Schema(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;
    private String cpf;
    private String email;
    private Sexo sexo;
    private String matricula;

}
