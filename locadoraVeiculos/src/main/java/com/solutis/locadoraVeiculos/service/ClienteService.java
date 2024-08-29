package com.solutis.locadoraVeiculos.service;

import com.solutis.locadoraVeiculos.model.Cliente;
import com.solutis.locadoraVeiculos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente inserir(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
