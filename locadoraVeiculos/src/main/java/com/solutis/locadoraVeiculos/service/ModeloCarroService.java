package com.solutis.locadoraVeiculos.service;

import com.solutis.locadoraVeiculos.model.ModeloCarro;
import com.solutis.locadoraVeiculos.repository.ModeloCarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloCarroService {

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;

    public List<ModeloCarro> getAllModelosCarro() {
        return modeloCarroRepository.findAll();
    }

    public Optional<ModeloCarro> getModeloCarroById(Long id) {
        return modeloCarroRepository.findById(id);
    }

    public ModeloCarro saveModeloCarro(ModeloCarro modeloCarro) {
        return modeloCarroRepository.save(modeloCarro);
    }

    public boolean deleteModeloCarro(Long id) {
        return modeloCarroRepository.findById(id).map(modeloCarro -> {
            modeloCarroRepository.delete(modeloCarro);
            return true;
        }).orElse(false);
    }
}
