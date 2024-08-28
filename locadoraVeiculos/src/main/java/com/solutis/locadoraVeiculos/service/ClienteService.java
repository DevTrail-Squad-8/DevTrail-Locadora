package com.solutis.locadoraVeiculos.service;

import org.springframework.boot.context.config.ConfigData.Option;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.solutis.locadoraVeiculos.model.Cliente;
import com.solutis.locadoraVeiculos.repository.ClienteRepository;
import java.util.Optional;


@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public Cliente inserir(Cliente cliente) {

        Optional<Cliente> clienteMesmoCpf = clienteRepository.findByCpf(cliente.getCpf());
        if (clienteMesmoCpf.isPresent()) {
            throw new RuntimeException("Cliente com o CPF já cadastrado.");
        }
        Optional<Cliente> clienteMesmoEmail = clienteRepository.findByEmail(cliente.getEmail());
        if (clienteMesmoCpf.isPresent()) {
            throw new RuntimeException("Cliente com o Email já cadastrado.");
        }

        return clienteRepository.save(cliente);

    }


}
