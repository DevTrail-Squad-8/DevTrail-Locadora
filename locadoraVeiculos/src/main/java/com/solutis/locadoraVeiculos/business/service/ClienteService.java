package com.solutis.locadoraVeiculos.business.service;

import com.solutis.locadoraVeiculos.api.dto.ClienteDTO;
import com.solutis.locadoraVeiculos.infra.exception.ResourceNotFoundException;
import com.solutis.locadoraVeiculos.infra.exception.DuplicateEmailException;
import com.solutis.locadoraVeiculos.infra.exception.InvalidDataException;
import com.solutis.locadoraVeiculos.infra.mapper.DozerMapper;
import com.solutis.locadoraVeiculos.infra.entity.Cliente;
import com.solutis.locadoraVeiculos.infra.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO create(ClienteDTO clienteDTO) {
        clienteRepository.findByEmail(clienteDTO.getEmail())
                .ifPresent(cliente -> {
                    throw new DuplicateEmailException("Email já cadastrado");
                });

        if (clienteDTO.getNome() == null || clienteDTO.getNome().isEmpty()) {
            throw new InvalidDataException("Nome não pode ser vazio");
        }

        Cliente cliente = DozerMapper.parseObject(clienteDTO, Cliente.class);
        Cliente savedCliente = clienteRepository.save(cliente);
        return DozerMapper.parseObject(savedCliente, ClienteDTO.class);
    }


    public ClienteDTO update(Long id, ClienteDTO clienteDTO) {
        Cliente existingCliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        DozerMapper.updateObject(clienteDTO, existingCliente);

        Cliente updatedCliente = clienteRepository.save(existingCliente);
        return DozerMapper.parseObject(updatedCliente, ClienteDTO.class);
    }

    public boolean delete(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + id));
        clienteRepository.delete(cliente);
        return true;
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
