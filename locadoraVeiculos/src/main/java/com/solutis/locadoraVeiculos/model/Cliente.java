package com.solutis.locadoraVeiculos.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Cliente extends Pessoa {

    @Column(nullable = false)
    private String numeroCNH;

    @OneToMany(mappedBy = "cliente")
    private List<Aluguel> alugueis;
}
