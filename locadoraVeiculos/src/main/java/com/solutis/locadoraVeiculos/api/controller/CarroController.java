package com.solutis.locadoraVeiculos.api.controller;

import com.solutis.locadoraVeiculos.api.dto.CarroDTO;
import com.solutis.locadoraVeiculos.infra.exception.ResourceNotFoundException;
import com.solutis.locadoraVeiculos.infra.mapper.DozerMapper;
import com.solutis.locadoraVeiculos.infra.entity.Acessorio;
import com.solutis.locadoraVeiculos.infra.entity.Carro;
import com.solutis.locadoraVeiculos.infra.entity.ModeloCarro;
import com.solutis.locadoraVeiculos.business.service.AcessorioService;
import com.solutis.locadoraVeiculos.business.service.CarroService;
import com.solutis.locadoraVeiculos.business.service.ModeloCarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @Autowired
    private ModeloCarroService modeloCarroService;

    @Autowired
    private AcessorioService acessorioService;

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
    public ResponseEntity<CarroDTO> createCarro(@RequestBody CarroDTO carroDto) {
        Carro carro = DozerMapper.parseObject(carroDto, Carro.class);

        if (carro.getModeloCarro() != null && carro.getModeloCarro().getId() != null) {
            ModeloCarro modeloCarro = modeloCarroService.getModeloCarroById(carro.getModeloCarro().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("ModeloCarro não encontrado com ID: " + carro.getModeloCarro().getId()));
            carro.setModeloCarro(modeloCarro);
        }

        if (carro.getAcessorios() != null) {
            List<Acessorio> acessorios = new ArrayList<>();
            for (Acessorio acessorio : carro.getAcessorios()) {
                if (acessorio.getId() != null) {
                    Optional<Acessorio> acessorioOpt = acessorioService.getAcessorioById(acessorio.getId());
                    if (acessorioOpt.isPresent()) {
                        acessorios.add(acessorioOpt.get());
                    } else {
                        throw new ResourceNotFoundException("Acessorio não encontrado com ID: " + acessorio.getId());
                    }
                } else {
                    Acessorio savedAcessorio = acessorioService.saveAcessorio(acessorio);
                    acessorios.add(savedAcessorio);
                }
            }
            carro.setAcessorios(acessorios);
        }

        Carro savedCarro = carroService.saveCarro(carro);
        CarroDTO savedCarroDto = DozerMapper.parseObject(savedCarro, CarroDTO.class);
        return ResponseEntity.ok(savedCarroDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CarroDTO> updateCarro(@PathVariable Long id, @RequestBody CarroDTO carroDetails) {
        Carro carro = carroService.getCarroById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado com ID: " + id));

        Long modeloCarroId = carroDetails.getModeloCarro().getId();
        if (modeloCarroId != null) {
            Optional<ModeloCarro> modeloCarroOpt = modeloCarroService.getModeloCarroById(modeloCarroId);
            if (modeloCarroOpt.isPresent()) {
                carro.setModeloCarro(modeloCarroOpt.get());
            } else {
                throw new ResourceNotFoundException("ModeloCarro não encontrado com ID: " + modeloCarroId);
            }
        }

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

    @GetMapping("/disponiveis")
    public ResponseEntity<List<CarroDTO>> listarVeiculosDisponiveis(
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) List<String> acessorios) {

        List<CarroDTO> veiculos = carroService.listarVeiculosDisponiveis(categoria, acessorios);
        return ResponseEntity.ok(veiculos);
    }
}
