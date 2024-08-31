package com.solutis.locadoraVeiculos.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Acessorio")
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;
}
