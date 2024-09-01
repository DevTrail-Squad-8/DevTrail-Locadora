package com.solutis.locadoraVeiculos.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "modelo_carro")
@Getter
@Setter
public class ModeloCarro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String descricao;

    @Column
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "fabricante_id", nullable = false)
    @JsonIgnoreProperties("modelos")
    private Fabricante fabricante;

    @OneToMany(mappedBy = "modeloCarro")
    @JsonIgnoreProperties({"modeloCarro", "acessorios"})
    private List<Carro> carros;
}