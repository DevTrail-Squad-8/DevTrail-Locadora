package com.solutis.locadoraVeiculos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotBlank
    private String placa;

    @Column
    @NotBlank
    private String chassi;

    @Column
    @NotBlank
    private String cor;

    @Column
    @NotNull
    private BigDecimal valorDiaria;

    @Column
    private String imagem;

    @ManyToOne
    @JoinColumn(name = "aluguel_id")
    @JsonIgnoreProperties("carros")
    private Aluguel aluguel;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Carro_Acessorio",
            joinColumns = { @JoinColumn(name = "carro_id") },
            inverseJoinColumns = { @JoinColumn(name = "acessorio_id") }
    )
    @JsonIgnoreProperties("carros")
    private List<Acessorio> acessorios;

    @ManyToOne
    @JoinColumn(name = "modelo_carro_id", nullable = false)
    @JsonIgnoreProperties("carros")
    private ModeloCarro modeloCarro;

}