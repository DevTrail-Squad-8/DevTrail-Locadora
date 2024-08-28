package com.solutis.locadoraVeiculos.repository;

import com.solutis.locadoraVeiculos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Cliente, Long> {
}