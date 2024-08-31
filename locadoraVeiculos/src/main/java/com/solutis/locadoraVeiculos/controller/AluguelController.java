package com.solutis.locadoraVeiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.solutis.locadoraVeiculos.service.AluguelService;
import com.solutis.locadoraVeiculos.service.CarroService;
import com.solutis.locadoraVeiculos.service.ClienteService;

public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @Autowired
    private CarroService carroService;

    @Autowired
    private ClienteService clienteService;

    

}
