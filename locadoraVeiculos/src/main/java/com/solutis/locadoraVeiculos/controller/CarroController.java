package com.solutis.locadoraVeiculos.controller;

import com.solutis.locadoraVeiculos.model.Carro;
import com.solutis.locadoraVeiculos.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public List<Carro> getAllCarros() {
        return carroService.getAllCarros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> getCarroById(@PathVariable Long id) {
        Optional<Carro> carro = carroService.getCarroById(id);
        return carro.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Carro createCarro(@RequestBody Carro carro) {
        return carroService.saveCarro(carro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> updateCarro(@PathVariable Long id, @RequestBody Carro carroDetails) {
        Optional<Carro> updatedCarro = carroService.updateCarro(id, carroDetails);
        return updatedCarro.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarro(@PathVariable Long id) {
        boolean isDeleted = carroService.deleteCarro(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}