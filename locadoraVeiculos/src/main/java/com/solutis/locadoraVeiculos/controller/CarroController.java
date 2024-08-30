package com.solutis.locadoraVeiculos.controller;

import com.solutis.locadoraVeiculos.dto.CarroDTO;
import com.solutis.locadoraVeiculos.exception.ResourceNotFoundException;
import com.solutis.locadoraVeiculos.mapper.DozerMapper;
import com.solutis.locadoraVeiculos.model.Carro;
import com.solutis.locadoraVeiculos.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public List<CarroDTO> getAllCarros() {
        List<Carro> carros = carroService.getAllCarros();
        return DozerMapper.parseListObjects(carros, CarroDTO.class);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> getCarroById(@PathVariable Long id) {
        Carro carro = carroService.getCarroById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado com ID: " + id));
        CarroDTO carroDto = DozerMapper.parseObject(carro, CarroDTO.class);
        return ResponseEntity.ok(carroDto);
    }

    @PostMapping
    public CarroDTO createCarro(@RequestBody CarroDTO carroDto) {
        Carro carro = DozerMapper.parseObject(carroDto, Carro.class);
        Carro savedCarro = carroService.saveCarro(carro);
        return DozerMapper.parseObject(savedCarro, CarroDTO.class);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroDTO> updateCarro(@PathVariable Long id, @RequestBody CarroDTO carroDetails) {
        Carro carro = carroService.getCarroById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado com ID: " + id));

        DozerMapper.updateObject(carroDetails, carro);

        Carro updatedCarro = carroService.saveCarro(carro);
        CarroDTO updatedCarroDto = DozerMapper.parseObject(updatedCarro, CarroDTO.class);
        return ResponseEntity.ok(updatedCarroDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarro(@PathVariable Long id) {
        carroService.deleteCarro(id);
        return ResponseEntity.noContent().build();
    }
}
