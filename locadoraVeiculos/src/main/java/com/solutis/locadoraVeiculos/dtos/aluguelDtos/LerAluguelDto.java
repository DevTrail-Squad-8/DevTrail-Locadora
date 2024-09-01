package com.solutis.locadoraVeiculos.dtos.aluguelDtos;

@Data
public class LerAluguelDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate dataPedido;

    private Date dataEntrega;

    private Date dataDevolucao;

    private BigDecimal valorTotal;

    private Motorista motorista;

    @JsonIgnoreProperties("aluguel")
    private ApoliceSeguro apoliceSeguro;

    private List<Carro> carros;
}
