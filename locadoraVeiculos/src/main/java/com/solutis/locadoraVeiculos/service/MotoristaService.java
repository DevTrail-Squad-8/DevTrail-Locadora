package com.solutis.locadoraVeiculos.service;

import com.solutis.locadoraVeiculos.dtos.MotoristaDto;
import com.solutis.locadoraVeiculos.exception.RequiredObjectIsNullException;
import com.solutis.locadoraVeiculos.exception.ResourceNotFoundException;
import com.solutis.locadoraVeiculos.exception.DuplicateEmailException;
import com.solutis.locadoraVeiculos.mapper.DozerMapper;
import com.solutis.locadoraVeiculos.model.Motorista;
import com.solutis.locadoraVeiculos.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class MotoristaService {

    private Logger logger = Logger.getLogger(MotoristaService.class.getName());

    @Autowired
    private MotoristaRepository repository;

    public MotoristaDto create(MotoristaDto motoristaDto) {

        if (motoristaDto == null) throw new RequiredObjectIsNullException();

        logger.info("Criando um motorista!");

        if (emailExists(motoristaDto.getEmail()))
            throw new DuplicateEmailException("Erro! Email já registrado.");

        Motorista motorista = DozerMapper.parseObject(motoristaDto, Motorista.class);
        motorista = repository.save(motorista);

        return DozerMapper.parseObject(motorista, MotoristaDto.class);
    }

    public MotoristaDto findById(Long id) {

        logger.info("Buscando um motorista!");

        Motorista motorista = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));

        return DozerMapper.parseObject(motorista, MotoristaDto.class);
    }

    public List<MotoristaDto> findAll() {

        logger.info("Buscando todos os motoristas!");

        List<Motorista> listaMotorista = repository.findAll();
        return listaMotorista.stream()
                .map(motorista -> DozerMapper.parseObject(motorista, MotoristaDto.class))
                .collect(Collectors.toList());
    }

    public MotoristaDto update(MotoristaDto motoristaDto) {

        if (motoristaDto == null) throw new RequiredObjectIsNullException();

        logger.info("Atualizando um motorista!");

        var entity = repository.findById(motoristaDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));

        if (!entity.getEmail().equals(motoristaDto.getEmail()) && emailExists(motoristaDto.getEmail()))
            throw new DuplicateEmailException("Erro! Email já registrado.");

        DozerMapper.updateObject(motoristaDto, entity);

        repository.save(entity);

        return motoristaDto;
    }

    public void delete(Long id) {

        logger.info("Deletando um motorista!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
        repository.delete(entity);
    }

    private boolean emailExists(String email) {
        Long count = repository.countByEmail(email);
        return count > 0;
    }
}
