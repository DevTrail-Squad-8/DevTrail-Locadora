package com.solutis.locadoraVeiculos.service;

import com.solutis.locadoraVeiculos.model.Carro;
import com.solutis.locadoraVeiculos.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> getAllCarros() {
        return carroRepository.findAll();
    }

    public Optional<Carro> getCarroById(Long id) {
        return carroRepository.findById(id);
    }

    public Carro saveCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    public Optional<Carro> updateCarro(Long id, Carro carroDetails) {
        return carroRepository.findById(id).map(carro -> {
            carro.setPlaca(carroDetails.getPlaca());
            carro.setChassi(carroDetails.getChassi());
            carro.setCor(carroDetails.getCor());
            carro.setValorTotal(carroDetails.getValorTotal());
            return carroRepository.save(carro);
        });
    }

    public boolean deleteCarro(Long id) {
        return carroRepository.findById(id).map(carro -> {
            carroRepository.delete(carro);
            return true;
        }).orElse(false);
    }
}
