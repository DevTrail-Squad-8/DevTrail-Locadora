package com.solutis.locadoraVeiculos.infra.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cliente extends Pessoa {

    @Column(nullable = false)
    private String numeroCNH;

    @OneToMany(mappedBy = "cliente")
    private List<Aluguel> alugueis;

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }
}
