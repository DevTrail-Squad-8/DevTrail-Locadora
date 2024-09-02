package com.solutis.locadoraVeiculos.service;

import com.solutis.locadoraVeiculos.dtos.acessorioDto.AcessorioDto;
import com.solutis.locadoraVeiculos.dtos.acessorioDto.LerAcessorioDto;
import com.solutis.locadoraVeiculos.exception.ResourceNotFoundException;
import com.solutis.locadoraVeiculos.mapper.DozerMapper;
import com.solutis.locadoraVeiculos.model.Acessorio;
import com.solutis.locadoraVeiculos.repository.AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcessorioService {

    @Autowired
    private AcessorioRepository acessorioRepository;

    public AcessorioDto criarAcessorio(AcessorioDto acessorioDto) {
        var acessorio = DozerMapper.parseObject(acessorioDto, Acessorio.class);
        var acessorioCriado = acessorioRepository.save(acessorio);
        return DozerMapper.parseObject(acessorioCriado, AcessorioDto.class);
    }

    public List<LerAcessorioDto> retornarTodos() {
        var acessoriosRetornados = acessorioRepository.findAll();
        return DozerMapper.parseListObjects(acessoriosRetornados, LerAcessorioDto.class);
    }

    public void deletarPorId(Long id) {
        var acessorio = recuperarAcessorioDoBanco(id);
        acessorioRepository.delete(acessorio);
    }

    public LerAcessorioDto retornaPorId(Long id) {
        var acessorio = recuperarAcessorioDoBanco(id);
        return DozerMapper.parseObject(acessorio, LerAcessorioDto.class);
    }

    private Acessorio recuperarAcessorioDoBanco(Long id){
        return acessorioRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
