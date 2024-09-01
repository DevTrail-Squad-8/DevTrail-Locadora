package com.solutis.locadoraVeiculos.service;

import com.solutis.locadoraVeiculos.dtos.modelosCarroDto.LerModeloCarroDto;
import com.solutis.locadoraVeiculos.dtos.modelosCarroDto.ModeloCarroDto;
import com.solutis.locadoraVeiculos.exception.ResourceNotFoundException;
import com.solutis.locadoraVeiculos.model.ModeloCarro;
import com.solutis.locadoraVeiculos.repository.FabricanteRepository;
import com.solutis.locadoraVeiculos.repository.ModeloCarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ModeloCarroService {

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;
    @Autowired
    private FabricanteRepository fabricanteRepository;


    public LerModeloCarroDto criarModeloCarro(ModeloCarroDto modeloCarroDto){
        ModeloCarro modeloCarro = new ModeloCarro();
        BeanUtils.copyProperties(modeloCarroDto,modeloCarro, "fabricante_id");
        modeloCarro.setFabricante(fabricanteRepository.findById(modeloCarroDto.getFabricante_id())
                            .orElseThrow(ResourceNotFoundException::new));


        LerModeloCarroDto lerModeloCarroDto = new LerModeloCarroDto();
        modeloCarro = modeloCarroRepository.save(modeloCarro);
        BeanUtils.copyProperties(modeloCarro,lerModeloCarroDto);
        return lerModeloCarroDto;
    }

    public List<LerModeloCarroDto> retornarTodosOsModelosCarro(){
        var modeloCarrosRecuperados = modeloCarroRepository.findAll();
        var modelosCarrosDto = modeloCarrosRecuperados
                .stream()
                .map(fabricante -> {
                 var modeloCarroDto = new LerModeloCarroDto();
                 BeanUtils.copyProperties(fabricante,modeloCarroDto);
                 return modeloCarroDto;
                })
                .toList();
        return modelosCarrosDto;
    }

    public LerModeloCarroDto retornarModeloCarroPorid(Long id){
        var modeloCarroRecuperado = recuperarModeloCarroPorId(id);
        var modeloCarroDto = new LerModeloCarroDto();
        BeanUtils.copyProperties(modeloCarroRecuperado,modeloCarroDto);
        return modeloCarroDto;
    }

    public void deletarModeloCarroPorId(Long id){
        var modeloCarroRecuperado = recuperarModeloCarroPorId(id);
        modeloCarroRepository.delete(modeloCarroRecuperado);
    }

    private ModeloCarro recuperarModeloCarroPorId(Long id) {
        return modeloCarroRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }


}

