package com.solutis.locadoraVeiculos.repository;

import com.solutis.locadoraVeiculos.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}