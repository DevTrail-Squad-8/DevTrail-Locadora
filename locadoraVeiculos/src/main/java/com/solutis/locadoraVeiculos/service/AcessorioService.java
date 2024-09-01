package com.solutis.locadoraVeiculos.service;

import com.solutis.locadoraVeiculos.dtos.acessorioDto.AcessorioDto;
import com.solutis.locadoraVeiculos.dtos.acessorioDto.LerAcessorioDto;
import com.solutis.locadoraVeiculos.exception.ResourceNotFoundException;
import com.solutis.locadoraVeiculos.model.Acessorio;
import com.solutis.locadoraVeiculos.repository.AcessorioRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcessorioService {

    @Autowired
    private AcessorioRepository acessorioRepository;

    public AcessorioDto criarAcessorio(AcessorioDto acessorioDto) {
        var acessorio = new Acessorio();
        BeanUtils.copyProperties(acessorioDto, acessorio);
        var acessorioCriado = acessorioRepository.save(acessorio);
        BeanUtils.copyProperties(acessorioCriado,acessorioDto);
        return acessorioDto;
    }

    public List<LerAcessorioDto> retornarTodos() {
        var acessoriosRetornados = acessorioRepository.findAll();
        var acessoriosDtos = acessoriosRetornados
                .stream()
                .map(acessorio ->{
                    var acessorioDto = new LerAcessorioDto();
                    BeanUtils.copyProperties(acessorio,acessorioDto);
                    return acessorioDto;})
                .toList();
        return acessoriosDtos;
    }

    public void deletarPorId(Long id) {
        var acessorio = recuperarAcessorioDoBanco(id);
        acessorioRepository.delete(acessorio);
    }


    public LerAcessorioDto retornaPorId(Long id) {
            var acessorio = recuperarAcessorioDoBanco(id);
            var acessorioDto = new LerAcessorioDto();
            BeanUtils.copyProperties(acessorio,acessorioDto);
            return acessorioDto;
    }

    private Acessorio recuperarAcessorioDoBanco(Long id){
        return acessorioRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
