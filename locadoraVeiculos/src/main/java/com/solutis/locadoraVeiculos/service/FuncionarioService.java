package com.solutis.locadoraVeiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.locadoraVeiculos.dtos.FuncionarioDto;
import com.solutis.locadoraVeiculos.exception.ResourceNotFoundException;
import com.solutis.locadoraVeiculos.model.Funcionario;
import com.solutis.locadoraVeiculos.repository.FuncionarioRepository;
import com.solutis.locadoraVeiculos.mapper.DozerMapper;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    private Logger logger = Logger.getLogger(FuncionarioService.class.getName());

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioDto cadastrarFuncionario(FuncionarioDto funcionarioDto) {

        logger.info("Cadastrando Funcionário");

        var funcionario = DozerMapper.parseObject(funcionarioDto, Funcionario.class);
        funcionario = funcionarioRepository.save(funcionario);
        return DozerMapper.parseObject(funcionario, FuncionarioDto.class);
    }

    public FuncionarioDto findById(Long id) {

        logger.info("Procurando um funcionário");

        Funcionario funcionario = funcionarioRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        return DozerMapper.parseObject(funcionario, FuncionarioDto.class);
    }

    public void delete(Long id) {

        logger.info("Deletando funcionário");

        var entity = funcionarioRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        funcionarioRepository.delete(entity);
    }

    public List<FuncionarioDto> findAll() {

        logger.info("Procurando todos os funcionários");

        List<Funcionario> listaFuncionario = funcionarioRepository.findAll();
        return listaFuncionario.stream()
                .map(funcionario -> DozerMapper.parseObject(funcionario, FuncionarioDto.class))
                .collect(Collectors.toList());
    }
}
