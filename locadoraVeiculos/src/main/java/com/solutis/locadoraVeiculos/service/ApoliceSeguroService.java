package com.solutis.locadoraVeiculos.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.locadoraVeiculos.dtos.ApoliceDto;
import com.solutis.locadoraVeiculos.exception.ResourceNotFoundException;
import com.solutis.locadoraVeiculos.model.ApoliceSeguro;
import com.solutis.locadoraVeiculos.repository.ApoliceSeguroRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApoliceSeguroService {
    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;

    public ApoliceDto criarApolice (ApoliceDto apoliceDto) {


        ApoliceSeguro apoliceSeguro = new ApoliceSeguro();
        BeanUtils.copyProperties(apoliceDto, apoliceSeguro);

        apoliceSeguro = apoliceSeguroRepository.save(apoliceSeguro);

        ApoliceDto apoliceCriada = new ApoliceDto();
        BeanUtils.copyProperties(apoliceSeguro, apoliceCriada);

        return apoliceCriada;

    }

    public ApoliceDto retornarApolicesById (Long id) {

        ApoliceSeguro apolice = apoliceSeguroRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));

        ApoliceDto apoliceDto = new ApoliceDto();
        BeanUtils.copyProperties(apolice, apoliceDto);

        return apoliceDto;
    }

    public List<ApoliceDto> retornarTodasApolices () {

        List<ApoliceSeguro> listaApolice = apoliceSeguroRepository.findAll();
        return listaApolice.stream()
                .map(apolice -> {
                    ApoliceDto apoliceDto = new ApoliceDto();
                    BeanUtils.copyProperties(apolice, apoliceDto);
                    return apoliceDto;
                })
                .collect(Collectors.toList());

    }

    public void deletarApolice ( Long id ){

        var entity = apoliceSeguroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
        apoliceSeguroRepository.delete(entity);
    }

}
