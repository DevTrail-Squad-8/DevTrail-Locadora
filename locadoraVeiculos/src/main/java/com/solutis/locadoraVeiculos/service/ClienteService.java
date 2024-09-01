package com.solutis.locadoraVeiculos.service;

import com.solutis.locadoraVeiculos.dto.ClienteDTO;
import com.solutis.locadoraVeiculos.exception.ResourceNotFoundException;
import com.solutis.locadoraVeiculos.exception.DuplicateEmailException;
import com.solutis.locadoraVeiculos.exception.InvalidDataException;
import com.solutis.locadoraVeiculos.mapper.DozerMapper;
import com.solutis.locadoraVeiculos.model.Cliente;
import com.solutis.locadoraVeiculos.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public ClienteDTO create(ClienteDTO clienteDTO) {
        motoristaRepository.findByEmail(clienteDTO.getEmail())
                .ifPresent(cliente -> {
                    throw new DuplicateEmailException("Email já cadastrado");
                });

        if (clienteDTO.getNome() == null || clienteDTO.getNome().isEmpty()) {
            throw new InvalidDataException("Nome não pode ser vazio");
        }

        Cliente cliente = DozerMapper.parseObject(clienteDTO, Cliente.class);
        Cliente savedCliente = motoristaRepository.save(cliente);
        return DozerMapper.parseObject(savedCliente, ClienteDTO.class);
    }


    public ClienteDTO update(Long id, ClienteDTO clienteDTO) {
        Cliente existingCliente = motoristaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        DozerMapper.updateObject(clienteDTO, existingCliente);

        Cliente updatedCliente = motoristaRepository.save(existingCliente);
        return DozerMapper.parseObject(updatedCliente, ClienteDTO.class);
    }

    public boolean delete(Long id) {
        Cliente cliente = motoristaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + id));
        motoristaRepository.delete(cliente);
        return true;
    }

    public Optional<ClienteDTO> findById(Long id) {
        return motoristaRepository.findById(id)
                .map(cliente -> DozerMapper.parseObject(cliente, ClienteDTO.class));
    }

    public Optional<ClienteDTO> findByCpf(String cpf) {
        return motoristaRepository.findByCpf(cpf)
                .map(cliente -> DozerMapper.parseObject(cliente, ClienteDTO.class));
    }

    public Optional<ClienteDTO> findByEmail(String email) {
        return motoristaRepository.findByEmail(email)
                .map(cliente -> DozerMapper.parseObject(cliente, ClienteDTO.class));
    }
}
