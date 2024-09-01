package com.solutis.locadoraVeiculos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Carro carro;

    private LocalDate dataInicio;
    private LocalDate dataFim;

    public double calcularCusto() {
        long dias = java.time.temporal.ChronoUnit.DAYS.between(dataInicio, dataFim);
        return dias * carro.getValorDiaria().doubleValue();
    }
}
