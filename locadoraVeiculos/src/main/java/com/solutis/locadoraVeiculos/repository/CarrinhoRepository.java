package com.solutis.locadoraVeiculos.repository;

import com.solutis.locadoraVeiculos.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}

