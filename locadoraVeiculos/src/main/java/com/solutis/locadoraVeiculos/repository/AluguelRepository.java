package com.solutis.locadoraVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutis.locadoraVeiculos.model.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Long>{
}
