package com.solutis.locadoraVeiculos.repository;

import com.solutis.locadoraVeiculos.model.Fabricante;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
}
