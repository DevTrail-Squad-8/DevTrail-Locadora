package com.solutis.locadoraVeiculos.repository;

import com.solutis.locadoraVeiculos.model.Carro;
import com.solutis.locadoraVeiculos.model.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {
}