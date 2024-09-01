package com.solutis.locadoraVeiculos.repository;

import com.solutis.locadoraVeiculos.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
