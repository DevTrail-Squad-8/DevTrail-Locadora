package com.solutis.locadoraVeiculos.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.DoubleStream;

@Getter
@Setter
@NoArgsConstructor
public class Reserva {

    private Motorista motorista;
    private List<Aluguel> itens;
    private LocalDate dataReserva;
    private DoubleStream custoTotal;

    public Reserva(Motorista cliente, List<Aluguel> itens, LocalDate dataReserva) {
        this.motorista = cliente;
        this.itens = itens;
        this.dataReserva = dataReserva;
        this.custoTotal = calcularCustoTotal();
    }

    private DoubleStream calcularCustoTotal() {
        return itens.stream().mapToDouble(Aluguel::getValorTotal);
    }
}
