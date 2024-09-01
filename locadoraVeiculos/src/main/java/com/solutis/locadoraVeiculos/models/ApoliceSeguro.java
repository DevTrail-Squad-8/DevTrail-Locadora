package com.solutis.locadoraVeiculos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
@Table(name = "apolice_seguro")
@Data
public class ApoliceSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column
    private BigDecimal valorFranquia;
    @Column
    private Boolean protecaoTerceiro;
    @Column
    private Boolean protecaoCausasNaturais;
    @Column
    private Boolean protecaoRoubo;

    @OneToOne(mappedBy = "apoliceSeguro")
    @JsonIgnoreProperties("apoliceSeguro")
    private Aluguel aluguel;

}