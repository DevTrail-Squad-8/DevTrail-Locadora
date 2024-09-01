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

    private List<ItemCarrinho> itens = new ArrayList<>();

    public void adicionarItem(ItemCarrinho item) {
        this.itens.add(item);
    }

    public void removerItem(ItemCarrinho item) {
        this.itens.remove(item);
    }

    public double calcularCustoTotal() {
        return itens.stream().mapToDouble(ItemCarrinho::calcularCusto).sum();
    }
}