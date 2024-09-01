package com.solutis.locadoraVeiculos.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.locadoraVeiculos.dtos.fabricantesDto.FabricanteDto;
import com.solutis.locadoraVeiculos.dtos.fabricantesDto.LerFabricanteDto;
import com.solutis.locadoraVeiculos.model.ApoliceSeguro;
import com.solutis.locadoraVeiculos.model.Fabricante;
import com.solutis.locadoraVeiculos.repository.FabricanteRepository;


import java.util.List;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    public FabricanteDto criarFabricante(FabricanteDto fabricanteDto) {
            var fabricante = new Fabricante();
            BeanUtils.copyProperties(fabricanteDto, fabricante);
            var fabricanteCriado = fabricanteRepository.save(fabricante);
            BeanUtils.copyProperties(fabricanteCriado,fabricanteDto);
            return fabricanteDto;

    }
    public List<LerFabricanteDto> retornar() {
        var fabricantesRetornados = fabricanteRepository.findAll();
        var fabricanteDtos = fabricantesRetornados
                .stream()
                .map(fabricante -> {
                    var fabricanteDto = new LerFabricanteDto();
                    BeanUtils.copyProperties(fabricante, fabricanteDto);
                    return fabricanteDto;
                })
                .toList();
        return fabricanteDtos;
    }

    public void deletarPorId(Long id) {
        var fabricante = retornarFabricanteDoBancoPorId(id);
        fabricanteRepository.delete(fabricante);

    }
    public LerFabricanteDto retornarPorId(Long id) {
        var fabricante = retornarFabricanteDoBancoPorId(id);
        var fabricanteDto = new LerFabricanteDto();
        BeanUtils.copyProperties(fabricante,fabricanteDto);
        return fabricanteDto;

    }
    private Fabricante retornarFabricanteDoBancoPorId(Long id) {
        return fabricanteRepository.findById(id).orElseThrow();

    }
}
