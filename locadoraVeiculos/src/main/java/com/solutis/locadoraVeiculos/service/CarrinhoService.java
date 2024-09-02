package com.solutis.locadoraVeiculos.service;

import com.solutis.locadoraVeiculos.model.Aluguel;
import com.solutis.locadoraVeiculos.model.Carrinho;
import com.solutis.locadoraVeiculos.model.Reserva;
import com.solutis.locadoraVeiculos.model.Motorista;
import com.solutis.locadoraVeiculos.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public Carrinho criarCarrinho() {
        return new Carrinho();
    }

    public Reserva confirmarReserva(Carrinho carrinho, Motorista motorista) {
        return new Reserva(motorista, (List<Aluguel>) carrinho, LocalDate.now());
    }
}
