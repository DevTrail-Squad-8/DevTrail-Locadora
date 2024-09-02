package com.solutis.locadoraVeiculos.service;

import com.solutis.locadoraVeiculos.dtos.modelosCarroDto.LerModeloCarroDto;
import com.solutis.locadoraVeiculos.dtos.modelosCarroDto.ModeloCarroDto;
import com.solutis.locadoraVeiculos.exception.ResourceNotFoundException;
import com.solutis.locadoraVeiculos.model.ModeloCarro;
import com.solutis.locadoraVeiculos.repository.FabricanteRepository;
import com.solutis.locadoraVeiculos.repository.ModeloCarroRepository;
import com.solutis.locadoraVeiculos.mapper.DozerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModeloCarroService {

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;

    @Autowired
    private FabricanteRepository fabricanteRepository;

    public LerModeloCarroDto criarModeloCarro(ModeloCarroDto modeloCarroDto) {
        var modeloCarro = DozerMapper.parseObject(modeloCarroDto, ModeloCarro.class);
        modeloCarro.setFabricante(fabricanteRepository.findById(modeloCarroDto.getFabricante_id())
                .orElseThrow(ResourceNotFoundException::new));

        modeloCarro = modeloCarroRepository.save(modeloCarro);
        return DozerMapper.parseObject(modeloCarro, LerModeloCarroDto.class);
    }

    public List<LerModeloCarroDto> retornarTodosOsModelosCarro() {
        var modeloCarrosRecuperados = modeloCarroRepository.findAll();
        return modeloCarrosRecuperados.stream()
                .map(modeloCarro -> DozerMapper.parseObject(modeloCarro, LerModeloCarroDto.class))
                .collect(Collectors.toList());
    }

    public LerModeloCarroDto retornarModeloCarroPorId(Long id) {
        var modeloCarroRecuperado = recuperarModeloCarroPorId(id);
        return DozerMapper.parseObject(modeloCarroRecuperado, LerModeloCarroDto.class);
    }

    public void deletarModeloCarroPorId(Long id) {
        var modeloCarroRecuperado = recuperarModeloCarroPorId(id);
        modeloCarroRepository.delete(modeloCarroRecuperado);
    }

    private ModeloCarro recuperarModeloCarroPorId(Long id) {
        return modeloCarroRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
