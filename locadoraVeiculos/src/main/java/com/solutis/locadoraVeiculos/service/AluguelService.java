package com.solutis.locadoraVeiculos.service;

import com.solutis.locadoraVeiculos.dto.AluguelDTO;
import com.solutis.locadoraVeiculos.exception.ResourceNotFoundException;
import com.solutis.locadoraVeiculos.mapper.DozerMapper;
import com.solutis.locadoraVeiculos.model.Aluguel;
import com.solutis.locadoraVeiculos.model.Carro;
import com.solutis.locadoraVeiculos.model.Cliente;
import com.solutis.locadoraVeiculos.model.StatusAluguel;
import com.solutis.locadoraVeiculos.repository.AluguelRepository;
import com.solutis.locadoraVeiculos.repository.CarroRepository;
import com.solutis.locadoraVeiculos.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    public AluguelDTO efetivarAluguel(Long aluguelId) {
        Aluguel aluguel = aluguelRepository.findById(aluguelId)
                .orElseThrow(() -> new ResourceNotFoundException("Aluguel não encontrado com ID: " + aluguelId));
        aluguel.setStatus(StatusAluguel.CONFIRMADO);
        aluguel.setDataPedido(LocalDateTime.now());
        Aluguel savedAluguel = aluguelRepository.save(aluguel);
        return DozerMapper.parseObject(savedAluguel, AluguelDTO.class);
    }
    public AluguelDTO adicionarVeiculoAoCarrinho(Long carroId, Long clienteId, LocalDateTime dataEntrega, LocalDateTime dataDevolucao) {
        Carro carro = carroRepository.findById(carroId)
                .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado com ID: " + carroId));

        Cliente cliente = motoristaRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com ID: " + clienteId));

        Aluguel aluguel = new Aluguel();
        aluguel.setCarro(carro);
        aluguel.setCliente(cliente);
        aluguel.setDataEntrega(dataEntrega);
        aluguel.setDataDevolucao(dataDevolucao);
        aluguel.calcularValorTotal(carro.getValorDiaria());
        aluguel.setStatus(StatusAluguel.RESERVADO);
        Aluguel savedAluguel = aluguelRepository.save(aluguel);
        return DozerMapper.parseObject(savedAluguel, AluguelDTO.class);
    }
    public AluguelDTO getAluguelById(Long id) {
        Aluguel aluguel = aluguelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluguel não encontrado com ID: " + id));
        return DozerMapper.parseObject(aluguel, AluguelDTO.class);
    }
}
