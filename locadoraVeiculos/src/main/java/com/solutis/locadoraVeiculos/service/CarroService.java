package com.solutis.locadoraVeiculos.service;

import com.solutis.locadoraVeiculos.dtos.carroDtos.CarroDto;
import com.solutis.locadoraVeiculos.dtos.carroDtos.LerCarroDto;
import com.solutis.locadoraVeiculos.exception.RequiredObjectIsNullException;
import com.solutis.locadoraVeiculos.exception.ResourceNotFoundException;
import com.solutis.locadoraVeiculos.mapper.DozerMapper;
import com.solutis.locadoraVeiculos.model.Acessorio;
import com.solutis.locadoraVeiculos.model.Carro;
import com.solutis.locadoraVeiculos.repository.AcessorioRepository;
import com.solutis.locadoraVeiculos.repository.CarroRepository;
import com.solutis.locadoraVeiculos.repository.ModeloCarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private AcessorioRepository acessorioRepository;

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;

    public LerCarroDto criarCarro(CarroDto carroDTO) {
        if (carroDTO == null) {
            throw new RequiredObjectIsNullException();
        }

        Carro carroCriado = DozerMapper.parseObject(carroDTO, Carro.class);
        carroCriado.setModeloCarro(
                modeloCarroRepository.findById(carroDTO.getModeloCarro_id())
                        .orElseThrow(ResourceNotFoundException::new)
        );

        List<Acessorio> listaAcessorio = carroDTO.getAcessorios_id().stream()
                .map(idAcessorio -> acessorioRepository.findById(idAcessorio)
                        .orElseThrow(ResourceNotFoundException::new))
                .collect(Collectors.toList());
        carroCriado.setAcessorios(listaAcessorio);

        carroCriado = carroRepository.save(carroCriado);
        return DozerMapper.parseObject(carroCriado, LerCarroDto.class);
    }

    public List<LerCarroDto> retornarTodosOsCarros() {
        var carrosRecuperadosDoBanco = carroRepository.findAll();
        return carrosRecuperadosDoBanco.stream()
                .map(carro -> DozerMapper.parseObject(carro, LerCarroDto.class))
                .collect(Collectors.toList());
    }

    public LerCarroDto retornarCarroPorId(long id) {
        var carroRecuperadoDoBanco = retornarCarroDoBancoPorId(id);
        return DozerMapper.parseObject(carroRecuperadoDoBanco, LerCarroDto.class);
    }

    public void deletarCarro(long id) {
        var carroRecuperadoDoBanco = retornarCarroDoBancoPorId(id);
        carroRepository.delete(carroRecuperadoDoBanco);
    }

    private Carro retornarCarroDoBancoPorId(long id) {
        return carroRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Carro adicionarAcessorio(long idCarro, long idAcessorio) {
        var carro = retornarCarroDoBancoPorId(idCarro);
        var acessorio = acessorioRepository.findById(idAcessorio)
                .orElseThrow(ResourceNotFoundException::new);

        carro.getAcessorios().add(acessorio);
        return carroRepository.save(carro);
    }
}
