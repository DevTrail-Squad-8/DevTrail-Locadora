package com.solutis.locadoraVeiculos.service;

import com.solutis.locadoraVeiculos.model.Carrinho;
import com.solutis.locadoraVeiculos.model.Reserva;
import com.solutis.locadoraVeiculos.model.Motorista;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CarrinhoService {

    public Carrinho criarCarrinho() {
        return new Carrinho();
    }

    public Reserva confirmarReserva(Carrinho carrinho, Motorista motorista) {
        return new Reserva(motorista, carrinho.getItens(), LocalDate.now());
    }
}
