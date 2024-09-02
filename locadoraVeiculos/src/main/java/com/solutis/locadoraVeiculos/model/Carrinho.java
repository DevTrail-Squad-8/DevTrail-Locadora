package com.solutis.locadoraVeiculos.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Carrinho {

    private List<Aluguel> itens = new ArrayList<>();

    public void adicionarItem(Aluguel item) {
        this.itens.add(item);
    }

    public void removerItem(Aluguel item) {
        this.itens.remove(item);
    }
}