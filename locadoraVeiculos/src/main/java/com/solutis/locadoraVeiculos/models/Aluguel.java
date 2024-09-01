package com.solutis.locadoraVeiculos.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.*;

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
    private BigDecimal valorTotal;


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