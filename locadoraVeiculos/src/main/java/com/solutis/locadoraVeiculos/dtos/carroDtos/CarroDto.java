package com.solutis.locadoraVeiculos.dtos.carroDtos;

import com.solutis.locadoraVeiculos.model.Carro;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CarroDto {

    private String placa;

    private String chassi;

    private String cor;

    private BigDecimal valorDiaria;

    private List<Long> acessorios_id;

    private Long modeloCarro_id;

    private String imagem;

}
