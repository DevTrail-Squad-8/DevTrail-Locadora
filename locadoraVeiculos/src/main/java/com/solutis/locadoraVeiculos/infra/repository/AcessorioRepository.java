package com.solutis.locadoraVeiculos.infra.repository;

import com.solutis.locadoraVeiculos.infra.entity.Acessorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcessorioRepository extends JpaRepository<Acessorio, Long>{
}
