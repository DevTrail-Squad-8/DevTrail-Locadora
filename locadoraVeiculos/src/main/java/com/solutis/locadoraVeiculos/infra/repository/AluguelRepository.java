package com.solutis.locadoraVeiculos.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutis.locadoraVeiculos.infra.entity.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Long>{
}
