package com.solutis.locadoraVeiculos.controller;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solutis.locadoraVeiculos.dto.AluguelDTO;
import com.solutis.locadoraVeiculos.service.AluguelService;
import com.solutis.locadoraVeiculos.service.CarroService;
import com.solutis.locadoraVeiculos.service.ClienteService;


@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @Autowired
    private CarroService carroService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/adicionar")
    public ResponseEntity<AluguelDTO> adicionarVeiculoAoCarrinho(
            @RequestParam Long carroId,
            @RequestParam Long clienteId,
            @RequestParam LocalDateTime dataEntrega,
            @RequestParam LocalDateTime dataDevolucao) {

        if (!carroService.getCarroById(carroId).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        if (!clienteService.findById(clienteId).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        AluguelDTO aluguelDTO = aluguelService.adicionarVeiculoAoCarrinho(carroId, clienteId, dataEntrega, dataDevolucao);
        return ResponseEntity.ok(aluguelDTO);
    }

    @PostMapping("/efetivar/{id}")
    public ResponseEntity<AluguelDTO> efetivarAluguel(@PathVariable Long id) {
        AluguelDTO aluguelDTO = aluguelService.efetivarAluguel(id);
        return ResponseEntity.ok(aluguelDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AluguelDTO> getAluguelById(@PathVariable Long id) {
        AluguelDTO aluguelDTO = aluguelService.getAluguelById(id);
        return ResponseEntity.ok(aluguelDTO);
    }
}

