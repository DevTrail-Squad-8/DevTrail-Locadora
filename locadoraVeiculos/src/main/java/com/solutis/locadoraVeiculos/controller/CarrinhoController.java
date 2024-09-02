package com.solutis.locadoraVeiculos.controller;

import com.solutis.locadoraVeiculos.model.Carrinho;
import com.solutis.locadoraVeiculos.model.ItemCarrinho;
import com.solutis.locadoraVeiculos.model.Motorista;
import com.solutis.locadoraVeiculos.model.Reserva;
import com.solutis.locadoraVeiculos.service.CarrinhoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carrinho")
@Tag(name = "Carrinho", description = "Endpoints para Gerenciamento do Carrinho de Aluguel")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    private Carrinho carrinho = new Carrinho();

    @PostMapping("/adicionar")
    @Operation(summary = "Adicionar item ao carrinho", description = "Adiciona um item ao carrinho de aluguel")
    public ResponseEntity<Void> adicionarItem(@RequestBody ItemCarrinho itemCarrinho) {
        carrinho.adicionarItem(itemCarrinho);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/resumo")
    @Operation(summary = "Resumo do carrinho", description = "Exibe o resumo dos itens no carrinho")
    public ResponseEntity<Carrinho> resumoCarrinho() {
        return ResponseEntity.status(HttpStatus.OK).body(carrinho);
    }

    @PostMapping("/confirmar")
    @Operation(summary = "Confirmar reserva", description = "Confirma a reserva e cria uma reserva finalizada")
    public ResponseEntity<Reserva> confirmarReserva(@RequestBody Motorista motorista) {
        Reserva reserva = carrinhoService.confirmarReserva(carrinho, motorista);
        carrinho = new Carrinho();
        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }
}