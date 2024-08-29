package com.solutis.locadoraVeiculos.service;

import com.solutis.locadoraVeiculos.model.Cliente;
import com.solutis.locadoraVeiculos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente inserir(Cliente cliente) {
        Optional<Cliente> clienteMesmoCpf = clienteRepository.findByCpf(cliente.getCpf());
        if (clienteMesmoCpf.isPresent()) {
            throw new RuntimeException("Cliente com o CPF já cadastrado.");
        }
        Optional<Cliente> clienteMesmoEmail = clienteRepository.findByEmail(cliente.getEmail());
        if (clienteMesmoEmail.isPresent()) {
            throw new RuntimeException("Cliente com o Email já cadastrado.");
        }
        return clienteRepository.save(cliente);
    }
}
