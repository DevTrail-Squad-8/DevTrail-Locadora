package com.solutis.locadoraVeiculos.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Reserva {

    private Motorista motorista;
    private List<ItemCarrinho> itens;
    private LocalDate dataReserva;
    private double custoTotal;

    public Reserva(Motorista cliente, List<ItemCarrinho> itens, LocalDate dataReserva) {
        this.motorista = cliente;
        this.itens = itens;
        this.dataReserva = dataReserva;
        this.custoTotal = calcularCustoTotal();
    }

    private double calcularCustoTotal() {
        return itens.stream().mapToDouble(ItemCarrinho::calcularCusto).sum();
    }
}
