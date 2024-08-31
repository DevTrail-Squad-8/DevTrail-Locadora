package com.solutis.locadoraVeiculos.business.service;

import com.solutis.locadoraVeiculos.api.dto.AluguelDTO;
import com.solutis.locadoraVeiculos.infra.exception.ResourceNotFoundException;
import com.solutis.locadoraVeiculos.infra.mapper.DozerMapper;
import com.solutis.locadoraVeiculos.infra.entity.Aluguel;
import com.solutis.locadoraVeiculos.infra.entity.Carro;
import com.solutis.locadoraVeiculos.infra.entity.Cliente;
import com.solutis.locadoraVeiculos.infra.entity.StatusAluguel;
import com.solutis.locadoraVeiculos.infra.repository.AluguelRepository;
import com.solutis.locadoraVeiculos.infra.repository.CarroRepository;
import com.solutis.locadoraVeiculos.infra.repository.ClienteRepository;
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
    private ClienteRepository clienteRepository;

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

        Cliente cliente = clienteRepository.findById(clienteId)
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
