package com.solutis.locadoraVeiculos.service;

import com.solutis.locadoraVeiculos.dtos.aluguelDtos.CriarAluguelDto;
import com.solutis.locadoraVeiculos.dtos.aluguelDtos.LerAluguelDto;
import com.solutis.locadoraVeiculos.exception.ResourceNotFoundException;
import com.solutis.locadoraVeiculos.mapper.DozerMapper;
import com.solutis.locadoraVeiculos.model.Aluguel;
import com.solutis.locadoraVeiculos.model.Carro;
import com.solutis.locadoraVeiculos.repository.AluguelRepository;
import com.solutis.locadoraVeiculos.repository.ApoliceSeguroRepository;
import com.solutis.locadoraVeiculos.repository.CarroRepository;
import com.solutis.locadoraVeiculos.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;

    private Logger logger = Logger.getLogger(AluguelService.class.getName());

    public LerAluguelDto criarAluguel(CriarAluguelDto criarAluguelDTO) {

        Aluguel aluguelCriado = DozerMapper.parseObject(criarAluguelDTO, Aluguel.class);
        aluguelCriado.setDataPedido(LocalDate.now());

        aluguelCriado.setMotorista(motoristaRepository.findById(criarAluguelDTO.getMotorista_id())
                .orElseThrow(ResourceNotFoundException::new));

        aluguelCriado.setApoliceSeguro(apoliceSeguroRepository.findById(criarAluguelDTO.getApolicesSeguro_id())
                .orElseThrow(ResourceNotFoundException::new));

        List<Carro> listaCarro = criarAluguelDTO
                .getCarros_id()
                .stream()
                .map(idCarro -> carroRepository.findById(idCarro)
                        .orElseThrow(ResourceNotFoundException::new))
                .collect(Collectors.toList());
        aluguelCriado.setCarros(listaCarro);

        aluguelCriado = aluguelRepository.save(aluguelCriado);
        return DozerMapper.parseObject(aluguelCriado, LerAluguelDto.class);
    }

    public LerAluguelDto retornarAlugueisById(Long id) {

        logger.info("Finding one rent!");

        Aluguel aluguel = aluguelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));

        return DozerMapper.parseObject(aluguel, LerAluguelDto.class);
    }

    public List<LerAluguelDto> retornarTodosAlugueis() {

        logger.info("Finding all rents!");

        List<Aluguel> listaAluguel = aluguelRepository.findAll();
        return DozerMapper.parseListObjects(listaAluguel, LerAluguelDto.class);
    }

    public void deletarAluguel(Long id) {

        logger.info("Deleting one rent!");

        var entity = aluguelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
        aluguelRepository.delete(entity);
    }
}
