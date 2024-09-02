package com.solutis.locadoraVeiculos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "aluguel")
@Getter
@Setter
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private LocalDate dataPedido;
    @Column
    private Date dataEntrega;
    @Column
    private Date dataDevolucao;
    @Column
    private Double valorTotal;


    @ManyToOne
    @JoinColumn(name = "motorista_id", nullable = false)
    @JsonIgnoreProperties("alugueis")
    private Motorista motorista;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apolice_seguro_id", referencedColumnName = "id")
    @JsonIgnoreProperties("aluguel")
    private ApoliceSeguro apoliceSeguro;

    @OneToMany(mappedBy = "aluguel")
    @JsonIgnoreProperties("aluguel")
    private List<Carro> carros = new ArrayList<>();

}