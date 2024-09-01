package com.solutis.locadoraVeiculos.repository;

import com.solutis.locadoraVeiculos.model.ApoliceSeguro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<ApoliceSeguro, Long> {
}
