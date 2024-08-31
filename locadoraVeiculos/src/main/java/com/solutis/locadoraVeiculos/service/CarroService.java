package com.solutis.locadoraVeiculos.service;

import com.solutis.locadoraVeiculos.dto.CarroDTO;
import com.solutis.locadoraVeiculos.mapper.DozerMapper;
import com.solutis.locadoraVeiculos.model.Acessorio;
import com.solutis.locadoraVeiculos.model.Carro;
import com.solutis.locadoraVeiculos.model.ModeloCarro;
import com.solutis.locadoraVeiculos.repository.CarroRepository;
import com.solutis.locadoraVeiculos.repository.ModeloCarroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;

    public List<CarroDTO> listarVeiculosDisponiveis(String categoria, List<String> acessorios) {
        List<Carro> carros = carroRepository.findAll();
        List<Carro> carrosFiltrados = new ArrayList<>();

        if (categoria != null) {
            for (Carro carro : carros) {
                if (carro.getCategoria().name().equalsIgnoreCase(categoria)) {
                    carrosFiltrados.add(carro);
                }
            }
        } else {
            carrosFiltrados.addAll(carros);
        }

        if (acessorios != null && !acessorios.isEmpty()) {
            Iterator<Carro> iterator = carrosFiltrados.iterator();
            while (iterator.hasNext()) {
                Carro carro = iterator.next();
                List<String> descricaoAcessorios = new ArrayList<>();
                for (Acessorio acessorio : carro.getAcessorios()) {
                    descricaoAcessorios.add(acessorio.getDescricao());
                }
                if (!descricaoAcessorios.containsAll(acessorios)) {
                    iterator.remove();
                }
            }
        }

        return DozerMapper.parseListObjects(carrosFiltrados, CarroDTO.class);
    }

    public List<Carro> getAllCarros() {
        return carroRepository.findAll();
    }

    public Optional<Carro> getCarroById(Long id) {
        return carroRepository.findById(id);
    }

    @Transactional
    public Carro saveCarro(Carro carro) {
        if (carro.getModeloCarro() != null && carro.getModeloCarro().getId() == null) {
            ModeloCarro modeloCarro = carro.getModeloCarro();
            modeloCarro = modeloCarroRepository.save(modeloCarro);
            carro.setModeloCarro(modeloCarro);
        }
        return carroRepository.save(carro);
    }

    public Optional<Carro> updateCarro(Long id, Carro carroDetails) {
        return carroRepository.findById(id).map(carro -> {
            carro.setPlaca(carroDetails.getPlaca());
            carro.setChassi(carroDetails.getChassi());
            carro.setCor(carroDetails.getCor());
            carro.setValorDiaria(carroDetails.getValorDiaria());
            carro.setCategoria(carroDetails.getCategoria());

            if (carroDetails.getModeloCarro() != null) {
                Optional<ModeloCarro> modeloCarroOpt = modeloCarroRepository.findById(carroDetails.getModeloCarro().getId());
                modeloCarroOpt.ifPresent(carro::setModeloCarro);
            }

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
