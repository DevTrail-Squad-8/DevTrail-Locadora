package com.solutis.locadoraVeiculos.infra.repository;
import com.solutis.locadoraVeiculos.infra.entity.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {
}