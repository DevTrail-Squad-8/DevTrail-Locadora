package com.solutis.locadoraVeiculos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "modelo_carro")
@Getter
@Setter
@NoArgsConstructor
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

    public ModeloCarro(String descricao, Categoria categoria, Fabricante fabricante) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.fabricante = fabricante;
        carros = new ArrayList<Carro>();
    }
}