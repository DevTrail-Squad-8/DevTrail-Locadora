package com.solutis.locadoraVeiculos.infra.repository;

import com.solutis.locadoraVeiculos.infra.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}