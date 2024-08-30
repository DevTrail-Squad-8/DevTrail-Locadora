package com.solutis.locadoraVeiculos.service;

import com.solutis.locadoraVeiculos.dto.ClienteDTO;
import com.solutis.locadoraVeiculos.mapper.DozerMapper;
import com.solutis.locadoraVeiculos.model.Cliente;
import com.solutis.locadoraVeiculos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO create(ClienteDTO clienteDTO) {
        Cliente cliente = DozerMapper.parseObject(clienteDTO, Cliente.class);
        Cliente savedCliente = clienteRepository.save(cliente);
        return DozerMapper.parseObject(savedCliente, ClienteDTO.class);
    }

    public ClienteDTO update(Long id, ClienteDTO clienteDTO) {
        return clienteRepository.findById(id)
                .map(existingCliente -> {
                    DozerMapper.updateObject(clienteDTO, existingCliente);
                    Cliente updatedCliente = clienteRepository.save(existingCliente);
                    return DozerMapper.parseObject(updatedCliente, ClienteDTO.class);
                })
                .orElse(null);
    }

    public boolean delete(Long id) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    return true;
                })
                .orElse(false);
    }

    public Optional<ClienteDTO> findById(Long id) {
        return clienteRepository.findById(id)
                .map(cliente -> DozerMapper.parseObject(cliente, ClienteDTO.class));
    }

    public Optional<ClienteDTO> findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf)
                .map(cliente -> DozerMapper.parseObject(cliente, ClienteDTO.class));
    }

    public Optional<ClienteDTO> findByEmail(String email) {
        return clienteRepository.findByEmail(email)
                .map(cliente -> DozerMapper.parseObject(cliente, ClienteDTO.class));
    }
}
