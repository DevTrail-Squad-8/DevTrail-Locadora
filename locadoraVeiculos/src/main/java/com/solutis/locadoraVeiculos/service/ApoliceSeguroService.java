package com.solutis.locadoraVeiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.locadoraVeiculos.dtos.ApoliceDto;
import com.solutis.locadoraVeiculos.exception.ResourceNotFoundException;
import com.solutis.locadoraVeiculos.mapper.DozerMapper;
import com.solutis.locadoraVeiculos.model.ApoliceSeguro;
import com.solutis.locadoraVeiculos.repository.ApoliceSeguroRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApoliceSeguroService {

    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;

    public ApoliceDto criarApolice(ApoliceDto apoliceDto) {
        ApoliceSeguro apoliceSeguro = DozerMapper.parseObject(apoliceDto, ApoliceSeguro.class);
        apoliceSeguro = apoliceSeguroRepository.save(apoliceSeguro);
        return DozerMapper.parseObject(apoliceSeguro, ApoliceDto.class);
    }

    public ApoliceDto retornarApolicesById(Long id) {
        ApoliceSeguro apolice = apoliceSeguroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
        return DozerMapper.parseObject(apolice, ApoliceDto.class);
    }

    public List<ApoliceDto> retornarTodasApolices() {
        List<ApoliceSeguro> listaApolice = apoliceSeguroRepository.findAll();
        return listaApolice.stream()
                .map(apolice -> DozerMapper.parseObject(apolice, ApoliceDto.class))
                .collect(Collectors.toList());
    }

    public void deletarApolice(Long id) {
        var entity = apoliceSeguroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
        apoliceSeguroRepository.delete(entity);
    }
}
