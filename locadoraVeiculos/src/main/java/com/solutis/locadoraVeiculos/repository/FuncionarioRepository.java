package com.solutis.locadoraVeiculos.repository;

import com.solutis.locadoraVeiculos.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}

