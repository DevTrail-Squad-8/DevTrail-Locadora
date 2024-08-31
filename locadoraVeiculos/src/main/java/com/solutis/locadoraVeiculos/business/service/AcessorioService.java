package com.solutis.locadoraVeiculos.business.service;

import com.solutis.locadoraVeiculos.infra.entity.Acessorio;
import com.solutis.locadoraVeiculos.infra.repository.AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AcessorioService {

    @Autowired
    private AcessorioRepository acessorioRepository;

    public Optional<Acessorio> getAcessorioById(Long id) {
        return acessorioRepository.findById(id);
    }

    public Acessorio saveAcessorio(Acessorio acessorio) {
        return acessorioRepository.save(acessorio);
    }
}
