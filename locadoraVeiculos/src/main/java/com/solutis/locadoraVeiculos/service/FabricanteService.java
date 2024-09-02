package com.solutis.locadoraVeiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.locadoraVeiculos.dtos.fabricantesDto.FabricanteDto;
import com.solutis.locadoraVeiculos.dtos.fabricantesDto.LerFabricanteDto;
import com.solutis.locadoraVeiculos.model.Fabricante;
import com.solutis.locadoraVeiculos.repository.FabricanteRepository;
import com.solutis.locadoraVeiculos.mapper.DozerMapper;

import java.util.List;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    public FabricanteDto criarFabricante(FabricanteDto fabricanteDto) {
        var fabricante = DozerMapper.parseObject(fabricanteDto, Fabricante.class);
        var fabricanteCriado = fabricanteRepository.save(fabricante);
        return DozerMapper.parseObject(fabricanteCriado, FabricanteDto.class);
    }

    public List<LerFabricanteDto> retornar() {
        var fabricantesRetornados = fabricanteRepository.findAll();
        return DozerMapper.parseListObjects(fabricantesRetornados, LerFabricanteDto.class);
    }

    public void deletarPorId(Long id) {
        var fabricante = retornarFabricanteDoBancoPorId(id);
        fabricanteRepository.delete(fabricante);
    }

    public LerFabricanteDto retornarPorId(Long id) {
        var fabricante = retornarFabricanteDoBancoPorId(id);
        return DozerMapper.parseObject(fabricante, LerFabricanteDto.class);
    }

    private Fabricante retornarFabricanteDoBancoPorId(Long id) {
        return fabricanteRepository.findById(id).orElseThrow();
    }
}
